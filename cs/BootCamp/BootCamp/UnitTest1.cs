using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCamp
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys("freek.ruskus@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("bootcamptest");
            driver.FindElement(By.Id("SubmitLogin")).Click();

            IWebElement HeaderValue = driver.FindElement(By.ClassName("page-heading"));
            IWebElement AccountName = driver.FindElement(By.ClassName("account"));
            Boolean SignOutPresent = driver.FindElements(By.ClassName("logout")).Count > 0;

            Assert.AreEqual("MY ACCOUNT", HeaderValue.Text);
            Assert.AreEqual("Freek Ruskus", AccountName.Text);
            Assert.IsTrue(SignOutPresent);

            driver.Close();
        }
    }
}
