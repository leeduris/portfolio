using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Collections;

namespace ShopMall
{
    public partial class ProductForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            int row = Int32.Parse(Session["prodParseNum"].ToString());

            phoneImage.Attributes["src"] = ResolveUrl("Images/cPhone" + row + ".jpg");

            DataTable data = DbManager.view("Product");
            TextBox1.Text = data.Rows[row].Field<int>(0).ToString();
            TextBox2.Text = data.Rows[row].Field<string>(1);
            TextBox3.Text = data.Rows[row].Field<decimal>(2).ToString();
            TextBox4.Text = data.Rows[row].Field<string>(3);

            sesName.Text = TextBox2.Text;
            sesPr.Text = (decimal.Parse(TextBox3.Text) * decimal.Parse(sesQu.SelectedValue)).ToString(); ;
        }

        protected void sesQu_SelectedIndexChanged(object sender, EventArgs e)
        {
            sesPr.Text = (decimal.Parse(TextBox3.Text) * decimal.Parse(sesQu.SelectedValue)).ToString();
        }


        protected void sesAd_Click(object sender, EventArgs e)
        {
            if (Session["sessionNum"] == null)
            {
                DataTable table = new DataTable();
                table.Columns.Add("Order Number", typeof(String));
                table.Columns.Add("Product ID", typeof(String));
                table.Columns.Add("Name", typeof(String));
                table.Columns.Add("Quantity", typeof(String));
                table.Columns.Add("Total Price", typeof(String));

                Session["sessionNum"] = 0;
                Session["session"] = table;
            }

            DataTable table2 = (DataTable)Session["session"];
            Session["sessionNum"] = (int)Session["sessionNum"] + 1;

            table2.Rows.Add(Session["sessionNum"], TextBox1.Text, sesName.Text, sesQu.Text, sesPr.Text);
            Session["session"] = table2;
            MessageBox.Show(this.Page, "Successfully, Added this Item Into Shoopping Cart");
        }

        protected void sendBtn_Click(object sender, EventArgs e)
        {
            Object[] rate = new Object[3];
            rate[0] = Int32.Parse(TextBox1.Text);
            rate[1] = Int32.Parse(rateText.Text);
            rate[2] = comText.Text;

            DbManager.addRating(rate);

            MessageBox.Show(this.Page, "Thanks for your Comment and Rating !");
        }

        protected void cartBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("ShoppingCart.aspx", true);
        }

        protected void homeBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("MainForm.aspx", true);
        }
    }
}
