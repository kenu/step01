package com.okmall.spring.controller;

import com.okmall.spring.component.message.Messages;
import com.okmall.spring.domain.Account;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.groups.Default;

@RequestMapping("/accounts")
@Controller
@RequiredArgsConstructor
public class AccountController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @ModelAttribute
    public AccountForm setUpForm() {
        return new AccountForm();
    }

    @GetMapping("/create")
    public String createForm() {
        return "account/createForm";
    }

    @PostMapping("/create")
    public String create(@Validated({Default.class, AccountForm.Create.class}) AccountForm form, BindingResult result,
                         Model model, RedirectAttributes redirectAttributes) {

        Account account = form.toAccount();
        logger.error(account.toString());
        if (result.hasErrors()) {
            model.addAttribute(
                    new Messages().error("Input values are invalid. Please confirm error messages."));
            return createForm();
        }

//        accountService.createAccount(account);

        redirectAttributes.addFlashAttribute(
                new Messages().success("Your account has been created. Please try login !!"));

        return "redirect:/login";
    }
}
