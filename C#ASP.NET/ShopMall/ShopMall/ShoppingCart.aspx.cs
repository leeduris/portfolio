using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ShopMall
{
    public partial class ShoppingCart : System.Web.UI.Page
    {
        DataTable sessionDT = new DataTable();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["session"] != null)
            {
                sessionDT = (DataTable)Session["session"];
                GridView1.DataSource = sessionDT;
                GridView1.DataBind();
            }

        }

        protected void buyBtn_Click(object sender, EventArgs e)
        {
            String msg = "";
            int cnt = 0;

            if (sessionDT != null)
            {
                DbManager.addSale(sessionDT);
                cnt++;
            }

            MessageBox.Show(this.Page, "Thanks for Purchasing !");
        }

        protected void homeBtn2_Click(object sender, EventArgs e)
        {
            Server.Transfer("MainForm.aspx", true);
        }

        protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            sessionDT.Rows.RemoveAt(e.RowIndex);
            GridView1.DataSource = sessionDT;
            GridView1.DataBind();

            MessageBox.Show(this.Page, "Deleted Successfully !");
        }

        protected void GridView1_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            GridViewRow row = GridView1.Rows[e.RowIndex];

            sessionDT.Rows[row.DataItemIndex][0] = row.Cells[0].Text;
            sessionDT.Rows[row.DataItemIndex][1] = row.Cells[1].Text;
            sessionDT.Rows[row.DataItemIndex][2] = row.Cells[2].Text;
            sessionDT.Rows[row.DataItemIndex][3] = row.Cells[3].Text;
            sessionDT.Rows[row.DataItemIndex][4] = row.Cells[4].Text;

            GridView1.DataSource = sessionDT;
            GridView1.DataBind();
        }

        protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
        {
            GridView1.EditIndex = e.NewEditIndex;
            GridView1.DataSource = sessionDT;
            GridView1.DataBind();
        }

        protected void GridView1_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            GridView1.EditIndex = -1;
            GridView1.DataSource = sessionDT;
            GridView1.DataBind();
        }

    }
}
