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
    public partial class BookAdd : System.Web.UI.Page
    {
        HttpClient client = new HttpClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Page.IsPostBack)
            {
            }
            else
            {
                GetBookList();
            }
        }

        private void GetBookList()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
                getIdList.DataSource = results;
                getIdList.DataValueField = "Id1";
                getIdList.DataTextField = "Name1";
                getIdList.DataBind();
            }
            else { }
        }


        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            dateTB.Text = releaseCalendar.SelectedDate.ToLongDateString();
        }

        protected void getIdList_SelectedIndexChanged(object sender, EventArgs e)
        {
            clear();
        }


        protected void addBtn_Click(object sender, EventArgs e)
        {
            AddBook();
        }

        protected void updateBtn_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(idTB.Text);
            UpdateBook(id);
        }

        protected void deleteBtn_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(idTB.Text);
            DeleteBook(id);
            clear();
        }

        protected void getBtn_Click(object sender, EventArgs e)
        {

            int id = Convert.ToInt32(getIdList.SelectedValue);
            GetBook(id);
        }

        private void AddBook()
        {
            var resultName = new KeyValuePair<string, string>("Name", nameTB.Text);
            var resultReleaseDate = new KeyValuePair<string, string>("ReleaseDate", dateTB.Text);
            var resultIsbn = new KeyValuePair<string, string>("ISBN", isbnTB.Text);
            client.BaseAddress = new Uri("http://localhost:56681");
            var content = new FormUrlEncodedContent(new[]
            {
                resultName, resultReleaseDate, resultIsbn
            });

            HttpResponseMessage response = client.PostAsync("/api/MegaBook/", content).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var result = JsonConvert.DeserializeObject<BookClass>(data);
                int id = result.Id1;
                GetBook(id);
                GetBookList();

                MessageBox.Show(this.Page, "Successfully Added A New Book !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Add A New Book !");
            }
        }

        private void UpdateBook(int id)
        {
            var resultName = new KeyValuePair<string, string>("Name", nameTB.Text);
            var resultReleaseDate = new KeyValuePair<string, string>("ReleaseDate", dateTB.Text);
            var resultIsbn = new KeyValuePair<string, string>("ISBN", isbnTB.Text);
            client.BaseAddress = new Uri("http://localhost:56681");
            var content = new FormUrlEncodedContent(new[]
            {
                resultName, resultReleaseDate, resultIsbn
            });

            HttpResponseMessage response = client.PutAsync("/api/MegaBook/" + id, content).Result;
            response.EnsureSuccessStatusCode();

            if (response.IsSuccessStatusCode)
            {
                GetBook(id);
                GetBookList();

                MessageBox.Show(this.Page, "Successfully Updated The Book !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Update The Book !");
            }
        }

        private void GetBook(int id)
        {
            string url = "http://localhost:56681/api/MegaBook/" + id;
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var result = JsonConvert.DeserializeObject<BookClass>(data);
                idTB.Text = Convert.ToString(result.Id1);
                nameTB.Text = result.Name1;
                dateTB.Text = Convert.ToString(result.ReleaseDate1);
                isbnTB.Text = result.Isbn1;
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Load A Book !");
            }
        }

        private void GetBook()
        {
            string url = "http://localhost:56681/api/MegaBook/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<BookClass>>(data);
            }
            else { }
        }

        private void DeleteBook(int id)
        {
            string url = "http://localhost:56681/api/MegaBook/" + id;
            HttpResponseMessage response = client.DeleteAsync(url).Result;
            response.EnsureSuccessStatusCode();

            if (response.IsSuccessStatusCode)
            {
                GetBookList();
                clear();
            }
            else { }
        }

        private void clear()
        {
            idTB.Text = "";
            nameTB.Text = "";
            dateTB.Text = "";
            isbnTB.Text = "";
        }

        protected void home_Click(object sender, EventArgs e)
        {
            Server.Transfer("Index.aspx", true);
        }

        protected void clearField_Click(object sender, EventArgs e)
        {
            clear();
        }
    }
}
