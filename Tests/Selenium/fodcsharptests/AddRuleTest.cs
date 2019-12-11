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
            
        }



        [Test]
        public void AddName()
        {

            // use 1.0.0.0/8 
            driver.Url = "http://localhost:8085/altlogin";

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

        [Test]
        public void AddWrongName()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("1' or '1' = '1 /*");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Enter a valid \'slug\' consisting of letters, numbers, underscores or hyphens.')]"));
        }

        [Test]
        public void AddWrongSourceAddress()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("efefef");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Invalid network address format')]"));
        }

        [Test]
        public void AddWrongDestinationAddress()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("drgr");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Invalid network address format')]"));
        }

        [Test]
        public void AddWithOutExpires()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("id_expires")).Click();
            driver.FindElement(By.Id("id_expires")).Clear();

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'This field is required.')]"));
        }

        [Test]
        public void AddWrongSrcPort()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("id_sourceport")).Click();
            driver.FindElement(By.Id("id_sourceport")).SendKeys("f//");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
        }

        [Test]
        public void AddWrongDestPort()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("id_destinationport")).Click();
            driver.FindElement(By.Id("id_destinationport")).SendKeys("f//");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
        }

        [Test]
        public void AddWrongPort()
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

            driver.FindElement(By.Id("routebutton")).Click();
            driver.FindElement(By.XPath("//*[contains(text(), 'Apply for a new rule')]"));

            driver.FindElement(By.Id("id_name")).Click();
            driver.FindElement(By.Id("id_name")).SendKeys("npattack");

            driver.FindElement(By.Id("id_source")).Click();
            driver.FindElement(By.Id("id_source")).SendKeys("0.0.0.0/0");

            driver.FindElement(By.Id("id_destination")).Click();
            driver.FindElement(By.Id("id_destination")).SendKeys("0.0.0.0/29");

            driver.FindElement(By.Id("id_port")).Click();
            driver.FindElement(By.Id("id_port")).SendKeys("f//");

            driver.FindElement(By.Id("applybutton")).Click();

            driver.FindElement(By.XPath("//*[contains(text(), 'Malformed port range format, example: 80,1000-1100,6000-6010')]"));
        }

        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
