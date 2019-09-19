using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace fodcsharptests
{
    [TestFixture]
    public class AddRuleTest
    {
        private IWebDriver driver;
        private WebDriverWait wait;


        [SetUp]

        public void start()
        {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
            driver.Url = "http://localhost:8083/altlogin";
        }



        [Test]
        public void AddName()
        {
           
            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("admin");
            driver.FindElement(By.Id("id_password")).Click();
            #region MyPasswordIsHere
            driver.FindElement(By.Id("id_password")).SendKeys("1");
            #endregion
            driver.FindElement(By.Id("applybutton")).Click();
            wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.TitleIs("GÉANT OC FoD :: My rules"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("1");
        }



        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
