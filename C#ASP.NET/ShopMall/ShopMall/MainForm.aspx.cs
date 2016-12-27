using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ShopMall
{
    public partial class MainForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            Session.Remove("prodParseNum");
            Session["prodParseNum"] = this.ImageButton1.AccessKey;
            Server.Transfer("ProductForm.aspx", true);
        }

        protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
        {
            Session.Remove("prodParseNum");
            Session["prodParseNum"] = this.ImageButton2.AccessKey;
            Server.Transfer("ProductForm.aspx", true);
        }

        protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
        {
            Session.Remove("prodParseNum");
            Session["prodParseNum"] = this.ImageButton3.AccessKey;
            Server.Transfer("ProductForm.aspx", true);
        }

        protected void cartBtn2_Click(object sender, EventArgs e)
        {
            Server.Transfer("ShoppingCart.aspx", true);
        }

        protected void adminBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("Login.aspx", true);
        }
    }
}
