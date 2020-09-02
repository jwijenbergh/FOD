using System;
using System.Configuration;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System.Configuration;

namespace fodcsharptests
{
    [TestFixture]
    public class RulesTest
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
        public void AddName()
        {

            // use 1.0.0.0/8 
            driver.Url = ConfigurationSettings.AppSettings.Get("Url"); ;
         

            driver.FindElement(By.Id("id_username")).Click();
            driver.FindElement(By.Id("id_username")).SendKeys("admin");
            driver.FindElement(By.Id("id_password")).Click();
            #region MyPasswordIsHere
            driver.FindElement(By.Id("id_password")).SendKeys("1");
            #endregion
            driver.FindElement(By.Id("applybutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'My rules')]"));

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("applybutton")).Click();

            //What should happen? 
        }


        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
