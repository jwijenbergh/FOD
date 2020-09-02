using System;
using System.Configuration;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;
using Assert = NUnit.Framework.Assert;

namespace fodcsharptests
{
    [TestFixture]
    public class SetupTest
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
        public void OnlyPassword()
        {
            driver.Url = "http://localhost:8084/setup/";

            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("Gf1!grGR00");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Name("netconf_device"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean) js.ExecuteScript("return arguments[0].required;", inputElement);
            if(!isRequired)
            {
                Assert.Fail();
            }

        }

        [Test]
        public void OnlyNotSavePassword()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("1");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Name("netconf_device"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyRouterHost()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_device")).Click();
            driver.FindElement(By.Id("id_netconf_device")).SendKeys("22");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyWrongRouterHost()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_device")).Click();
            driver.FindElement(By.Id("id_netconf_device")).SendKeys("<>");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyRouterPort()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_port")).Click();
            driver.FindElement(By.Id("id_netconf_port")).SendKeys("22");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyWrongRouterPort()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_port")).Click();
            driver.FindElement(By.Id("id_netconf_port")).SendKeys("<>");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyRouterUser()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_user")).Click();
            driver.FindElement(By.Id("id_netconf_user")).SendKeys("user");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyWrongRouterUser()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_user")).Click();
            driver.FindElement(By.Id("id_netconf_user")).SendKeys("<>");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyRouterPassword()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_pass")).Click();
            driver.FindElement(By.Id("id_netconf_pass")).SendKeys("Gf1!grGR00");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyNotSaveRouterPassword()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_netconf_pass")).Click();
            driver.FindElement(By.Id("id_netconf_pass")).SendKeys("1");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyTestIP()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_test_peer_addr")).Click();
            driver.FindElement(By.Id("id_test_peer_addr")).SendKeys("0.0.0.0/30");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void OnlyWrongTestIP()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_test_peer_addr")).Click();
            driver.FindElement(By.Id("id_test_peer_addr")).SendKeys("<>");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        //[Test]
        //public void GoodData()
        //{
        //    driver.Url = "http://localhost:8081/setup";

        //    driver.FindElement(By.Id("id_password")).Click();
        //    driver.FindElement(By.Id("id_password")).SendKeys("1");
        //    driver.FindElement(By.Id("id_netconf_device")).Click();
        //    driver.FindElement(By.Id("id_netconf_device")).SendKeys("1.0.0.0/8");
        //    driver.FindElement(By.Id("id_netconf_port")).Click();
        //    driver.FindElement(By.Id("id_netconf_port")).SendKeys("1.0.0.0/8");
        //    driver.FindElement(By.Id("id_netconf_user")).Click();
        //    driver.FindElement(By.Id("id_netconf_user")).SendKeys("user");
        //    driver.FindElement(By.Id("id_netconf_pass")).Click();
        //    driver.FindElement(By.Id("id_netconf_pass")).SendKeys("Gf12!grGR00");
        //    driver.FindElement(By.Id("id_test_peer_addr")).Click();
        //    driver.FindElement(By.Id("id_test_peer_addr")).SendKeys("1.0.0.0/8");
        //    driver.FindElement(By.XPath("//input[@type='submit']")).Click();
        //    IAlert alert = wait.Until(ExpectedConditions.AlertIsPresent());
        //    string text = alert.Text;
        //    if (text == "Fields must be filled out!")
        //    {
        //        alert.Accept();
        //    }
        //}

        [Test]
        public void WrongData()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("*/,");
            driver.FindElement(By.Id("id_netconf_device")).Click();
            driver.FindElement(By.Id("id_netconf_device")).SendKeys("/*");
            driver.FindElement(By.Id("id_netconf_port")).Click();
            driver.FindElement(By.Id("id_netconf_port")).SendKeys("*/");
            driver.FindElement(By.Id("id_netconf_user")).Click();
            driver.FindElement(By.Id("id_netconf_user")).SendKeys("/*");
            driver.FindElement(By.Id("id_netconf_pass")).Click();
            driver.FindElement(By.Id("id_netconf_pass")).SendKeys("*/");
            driver.FindElement(By.Id("id_test_peer_addr")).Click();
            driver.FindElement(By.Id("id_test_peer_addr")).SendKeys("*/");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [Test]
        public void EmptyFeilds()
        {
            driver.Url = "http://localhost:8081/setup";

            driver.FindElement(By.Id("id_password")).Click();
            driver.FindElement(By.Id("id_password")).SendKeys("");
            driver.FindElement(By.Id("id_netconf_device")).Click();
            driver.FindElement(By.Id("id_netconf_device")).SendKeys("");
            driver.FindElement(By.Id("id_netconf_port")).Click();
            driver.FindElement(By.Id("id_netconf_port")).SendKeys("");
            driver.FindElement(By.Id("id_netconf_user")).Click();
            driver.FindElement(By.Id("id_netconf_user")).SendKeys("");
            driver.FindElement(By.Id("id_netconf_pass")).Click();
            driver.FindElement(By.Id("id_netconf_pass")).SendKeys("");
            driver.FindElement(By.Id("id_test_peer_addr")).Click();
            driver.FindElement(By.Id("id_test_peer_addr")).SendKeys("");
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
            IWebElement inputElement = driver.FindElement(By.Id("id_password"));
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            bool isRequired = (Boolean)js.ExecuteScript("return arguments[0].required;", inputElement);
            if (!isRequired)
            {
                Assert.Fail();
            }
        }

        [TearDown]

        public void stop()
        {
            driver.Quit();
            driver = null;
        }
    }
}
