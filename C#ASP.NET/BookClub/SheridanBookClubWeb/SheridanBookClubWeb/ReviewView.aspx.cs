using Newtonsoft.Json;
using SheridanBookClubWeb.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SheridanBookClubWeb
{
    public partial class ReviewView : System.Web.UI.Page
    {
        HttpClient client = new HttpClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack)
            {
            }
            else
            {
                GetBookNameList();
                GetBookNameGridView();

                GetBookIdList();
                GetBookIdGridView();

                GetReviewerList();
                GetReviewerGridView();

                clear();
            }
        }

        protected void bookNameList_SelectedIndexChanged(object sender, EventArgs e)
        {
            if ( bookNameList.SelectedItem.Value == "")
            {
                GetBookNameGridView();
            }
            else
            {
                int id = Convert.ToInt32(bookNameList.SelectedItem.Value);
                GetBookByNameGridView(id);
            }
        }

        protected void bookIdList_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (bookIdList.SelectedItem.Value == "")
            {
                GetBookIdGridView();
            }
            else
            {
                int id = Convert.ToInt32(bookIdList.SelectedItem.Value);
                GetBookByIdGridView(id);
            }
        }

        protected void reviewerList_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (reviewerList.SelectedItem.Value == "")
            {
                GetReviewerGridView();
            }
            else
            {
                int id = Convert.ToInt32(reviewerList.SelectedItem.Value);
                GetReviewerByNameGridView(id);
            }
        }


        private void GetBookNameList()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
                bookNameList.DataSource = results;
                bookNameList.DataValueField = "Id1";
                bookNameList.DataTextField = "Name1" ;
                bookNameList.DataBind();
            }
            else { }
        }

        private void GetBookNameGridView()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
                bookNameGridView.DataSource = results;
                bookNameGridView.DataBind();
            }
            else { }
        }

        private void GetBookByNameGridView(int id)
        {
            string url = "http://localhost:56681/api/MegaBook/" + id;
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<BookClass>(data);
                List<BookClass> result = new List<BookClass>();
                result.Add(results);
                bookNameGridView.DataSource = result;
                bookNameGridView.DataBind();
            }
            else { }
        }

        private void GetBookIdList()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
                bookIdList.DataSource = results;
                bookIdList.DataValueField = "Id1";
                bookIdList.DataTextField = "Id1";
                bookIdList.DataBind();
            }
            else { }
        }

        private void GetBookIdGridView()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
                bookIdGridView.DataSource = results;
                bookIdGridView.DataBind();
            }
            else { }
        }

        private void GetBookByIdGridView(int id)
        {
            string url = "http://localhost:56681/api/MegaBook/" + id;
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<BookClass>(data);
                List<BookClass> result = new List<BookClass>();
                result.Add(results);
                bookIdGridView.DataSource = result;
                bookIdGridView.DataBind();
            }
            else { }
        }

        private void GetReviewerList()
        {
            string url = "http://localhost:56681/api/MegaReview/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<ReviewClass>>(data);
                reviewerList.DataSource = results;
                reviewerList.DataValueField = "Id1";
                reviewerList.DataTextField = "Reviewer1";
                reviewerList.DataBind();
            }
            else { }
        }

        private void GetReviewerGridView()
        {
            string url = "http://localhost:56681/api/MegaReview/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<ReviewClass>>(data);
                reviewerGridView.DataSource = results;
                reviewerGridView.DataBind();
            }
            else { }
        }

        private void GetReviewerByNameGridView(int id)
        {
            string url = "http://localhost:56681/api/MegaReview/" + id;
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<ReviewClass>(data);
                List<ReviewClass> result = new List<ReviewClass>();
                result.Add(results);
                reviewerGridView.DataSource = result;
                reviewerGridView.DataBind();
            }
            else { }
        }

        private void clear()
        {
            bookNameList.Items.Insert(0, "");
            bookIdList.Items.Insert(0, "");
            reviewerList.Items.Insert(0, "");
        }

        protected void home_Click(object sender, EventArgs e)
        {
            Server.Transfer("Index.aspx", true);
        }
    }
}
