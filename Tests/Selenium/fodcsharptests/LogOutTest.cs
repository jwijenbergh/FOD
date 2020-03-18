using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace fodcsharptests
{
    [TestFixture]
    public class LogOutTest
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
            driver.Url = "http://localhost:8081/altlogin";

            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("admin");
            driver.FindElement(By.Id("id_password")).Click();
            #region MyPasswordIsHere
            driver.FindElement(By.Id("id_password")).SendKeys("1");
            #endregion
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'My rules')]"));

            driver.FindElement(By.ClassName("fa-user")).Click();
            driver.FindElement(By.ClassName("fa-sign-out")).Click();

            wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.TitleIs("Example Domain"));

        }


        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
