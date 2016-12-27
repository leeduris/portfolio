using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SheridanBookClubWeb
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void bookBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("BookAdd.aspx", true);
        }

        protected void reviewBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("ReviewAdd.aspx", true);
        }

        protected void viewBtn_Click(object sender, EventArgs e)
        {
            Server.Transfer("ReviewView.aspx", true);
        }
    }
}
