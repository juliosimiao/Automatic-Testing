package pageObjects;

import org.openqa.selenium.By;

/**
 * Created by Julio on 16.6.2017.
 */
public class LoginPageObjects {

    By SignInButton = By.className("login");
    By loginRegion = By.className("europe");
    By loginPortlet = By.id("p_p_id_login_WAR_24alifepublicportlet_");
    By email = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("doLogin");

    public By getSignInButton() {
        return SignInButton;
    }

    public By getLoginRegion() {
        return loginRegion;
    }

    public By getLoginPortlet() {
        return loginPortlet;
    }

    public By getEmail() {
        return email;
    }

    public By getPassword() {
        return password;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public void setSignInButton(By signInButton) {
        SignInButton = signInButton;
    }

    public void setLoginRegion(By loginRegion) {
        this.loginRegion = loginRegion;
    }

    public void setLoginPortlet(By loginPortlet) {
        this.loginPortlet = loginPortlet;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public void setPassword(By password) {        this.password = password;
    }

    public void setLoginButton(By loginButton) {
        this.loginButton = loginButton;
    }
}
