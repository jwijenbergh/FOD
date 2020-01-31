using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace fodcsharptests
{
    [TestFixture]
    public class LoginTest
    {
        private IWebDriver driver;
        private WebDriverWait wait;

        [SetUp]

        public void start()
        {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
        }

        

        [Test]
        public void SuccessLogin()
        {
            driver.Url = "http://localhost:8085/altlogin";


            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("admin");
            driver.FindElement(By.Id("id_password")).Click();
            #region MyPasswordIsHere
            driver.FindElement(By.Id("id_password")).SendKeys("1");
            #endregion
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'My rules')]"));
        }

        [Test]
        public void LoginWithoutLogin()
        {
            driver.Url = "http://localhost:8085/altlogin";


            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("");
            driver.FindElement(By.Id("id_password")).Click();
            #region MyPasswordIsHere
            driver.FindElement(By.Id("id_password")).SendKeys("Password");
            #endregion
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'This field is required.')]"));

        }
        


        [Test]
        public void LoginWithoutPassword()
        {
            driver.Url = "http://localhost:8085/altlogin";


            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("ecaterina.wp8t3");
            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("");
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'This field is required.')]"));
         
        }

        

        [Test]
        public void LoginWithoutData()
        {
            driver.Url = "http://localhost:8085/altlogin";


            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("");
            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("");
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'This field is required.')]"));

        }

        [Test]
        public void LoginWithWrongData()
        {
            driver.Url = "http://localhost:8085/altlogin";


            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("rdg");
            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("esf");
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Please enter a correct username and password. Note that both fields are case-sensitive.')]"));

        }


        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
