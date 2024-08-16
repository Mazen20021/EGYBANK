package com.egypay.egypay.Controller;

import com.egypay.egypay.Models.DTO.BankDTO;
import com.egypay.egypay.Models.DTO.FavBankDTO;
import com.egypay.egypay.Models.DTO.UserDTO;
import com.egypay.egypay.Services.BankServiceINT;
import com.egypay.egypay.Services.FavBankService;
import com.egypay.egypay.Services.UserServiceINT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BankController {

   private final UserServiceINT userService;
   private final BankServiceINT bankService;
   private final FavBankService favBankService;

    @RequestMapping("/")
    public String logIn(Model model) {
        if(!model.containsAttribute("user")) {
            model.addAttribute("user", new UserDTO(0L, "", "", "", "",0D));
        }
            return "LogIn";
    }

    @RequestMapping("/Login")
    public String findUserByEmail(@ModelAttribute("user") UserDTO userDto , RedirectAttributes redirectAttributes) {
        if(userService.FindUserByEmail(userDto)){
            redirectAttributes.addFlashAttribute("user", userDto);
            if(userDto.getEmail().contains("_bk_"))
            {
                return "redirect:/AdminHome";
            }else
            {
                return "redirect:/Home";
            }

        }
        return "redirect:/RegForm";
    }
    @RequestMapping("/RegForm")
    public String Regform(@ModelAttribute("user") UserDTO userDto)
    {
        return "Reg";
    }
    @RequestMapping("/RegisterForm")
    public String Reg(@ModelAttribute("user") UserDTO user , RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/Register";
    }

    @RequestMapping("/Register")
    public String Main(@ModelAttribute("user") UserDTO user)
    {
        if(userService.saveUser(user))
        {
            return "redirect:/";

        }else
        {
            return "Fail";
        }
    }
    @RequestMapping("/Home")
    public String Home(Model model , @ModelAttribute("user") UserDTO userDto , RedirectAttributes redirectAttributes)
    {
        model.addAttribute("fullname", userService.findUserEntityByEmail(userDto.getEmail()).getFullName());
        redirectAttributes.addFlashAttribute("user", userDto);
        return "index";
    }
    @RequestMapping("/AdminHome")
    public String AdminHome(Model model , @ModelAttribute("user") UserDTO userDto , RedirectAttributes redirectAttributes)
    {
        model.addAttribute("fullname", userService.findUserEntityByEmail(userDto.getEmail()).getFullName());
        redirectAttributes.addFlashAttribute("user",userDto);
        return "Adminindex";
    }
    @RequestMapping("/BankMoney")
    public String BankMoney(@ModelAttribute("Bank") BankDTO bankDTO, Model model , RedirectAttributes redirectAttributes)
    {
        double balance = bankService.findBankEntitiesByName(bankDTO.getName()).getBalance();
        model.addAttribute("balance", balance);
        redirectAttributes.addFlashAttribute("bank", bankDTO);
        return "SendMoney";
    }
    @PostMapping("/SendMoney")
    public String SendMoney(@ModelAttribute("Bank") FavBankDTO favBankDTO , Model model , RedirectAttributes redirectAttributes)
    {
        BankDTO bankDTO = new BankDTO();
        System.out.println(favBankDTO.getAmount());
        System.out.println(favBankDTO.getSwiftcode());
        model.addAttribute("balance" , bankService.findBankEntitiesByName(bankDTO.getName()).getBalance());
        return "SendMoney";
    }
}

