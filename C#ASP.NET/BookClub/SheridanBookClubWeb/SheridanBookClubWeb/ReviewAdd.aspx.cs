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
    public partial class ReviewAdd : System.Web.UI.Page
    {
        HttpClient client = new HttpClient();
        int selectedBookId;

        protected void Page_Load(object sender, EventArgs e)
        {
            if(Page.IsPostBack)
            {
                postBackTB.Text = (Convert.ToInt32(postBackTB.Text) + 1).ToString();
                MessageBox.Show(this.Page, "Yes, Postback " + postBackTB.Text);
            }
            else
            {
                GetBookList();
                GetReviewList();
                postBackTB.Text = "0";
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
                bookList.DataSource = results;
                bookList.DataValueField = "Id1";
                bookList.DataTextField = "Name1";
                bookList.DataBind();
            }
            else { }
        }

        private void GetReviewList()
        {
            string url = "http://localhost:56681/api/MegaReview/";
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var results = JsonConvert.DeserializeObject<List<ReviewClass>>(data);
                getNameTBList.DataSource = results;
                getNameTBList.DataValueField = "Id1";
                getNameTBList.DataTextField = "Id1";
                //getNameTBList.DataTextField = "Reviewer1";
                getNameTBList.DataBind();
            }
            else { }
        }

        protected void bookList_SelectedIndexChanged(object sender, EventArgs e)
        {
            clear();
        }

        protected void getNameTBList_SelectedIndexChanged(object sender, EventArgs e)
        {
            clear();
        }

        protected void addBtn_Click(object sender, EventArgs e)
        {
            selectedBookId = Convert.ToInt32(bookList.SelectedItem.Value);
            AddReview();
        }

        protected void updateBtn_Click(object sender, EventArgs e)
        {
            selectedBookId = Convert.ToInt32(bookList.SelectedItem.Value);
            int id = Convert.ToInt32(reviewIdTB.Text);
            UpdateReview(id);
        }

        protected void deleteBtn_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(reviewIdTB.Text);
            DeleteReview(id);

        }

        protected void getBtn_Click(object sender, EventArgs e)
        {
            int selectedReviewId = Convert.ToInt32(getNameTBList.SelectedItem.Value);
            GetReview(selectedReviewId);
        }

        private void AddReview()
        {
            var resultReviewer = new KeyValuePair<string, string>("Reviewer", reviewerTB.Text);
            var resultReviews = new KeyValuePair<string, string>("Reviews", reviewTB.Text);
            var resultDate = new KeyValuePair<string, string>("Date", Convert.ToString(DateTime.Now));
            var resultRating = new KeyValuePair<string, string>("Rating", ratingList.SelectedValue);
            var resultBookID = new KeyValuePair<string, string>("BookID", Convert.ToString(selectedBookId));
            client.BaseAddress = new Uri("http://localhost:56681");
            var content = new FormUrlEncodedContent(new[]
            {
                resultReviewer, resultReviews, resultDate, resultRating, resultBookID
            });

            HttpResponseMessage response = client.PostAsync("/api/MegaReview/", content).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var result = JsonConvert.DeserializeObject<ReviewClass>(data);
                reviewIdTB.Text = Convert.ToString(result.Id1);
                reviewerTB.Text = result.Reviewer1;
                reviewTB.Text = result.Reviews1;
                ratingList.SelectedValue = Convert.ToString(result.Rating1);

                GetReviewList();

                if(Session[result.Reviewer1] == null)
                {
                    Session[result.Reviewer1] = 1;
                }
                else
                {
                    Session[result.Reviewer1] = Convert.ToInt32(Session[result.Reviewer1]) + 1;
                }
                sessionView();

                MessageBox.Show(this.Page, "Successfully, Added to A New Review !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Add A New Review !");
            }
        }

        private void UpdateReview(int id)
        {
            selectedBookId = Convert.ToInt32(bookList.SelectedItem.Value);

            var resultReviewer = new KeyValuePair<string, string>("Reviewer", reviewerTB.Text);
            var resultReviews = new KeyValuePair<string, string>("Reviews", reviewTB.Text);
            var resultDate = new KeyValuePair<string, string>("Date", Convert.ToString(DateTime.Now));
            var resultRating = new KeyValuePair<string, string>("Rating", ratingList.SelectedValue);
            var resultBookID = new KeyValuePair<string, string>("BookID", Convert.ToString(selectedBookId));
            client.BaseAddress = new Uri("http://localhost:56681");
            var content = new FormUrlEncodedContent(new[]
            {
                resultReviewer, resultReviews, resultDate, resultRating, resultBookID
            });

            HttpResponseMessage response = client.PutAsync("/api/MegaReview/" + id, content).Result;
            response.EnsureSuccessStatusCode();

            if (response.IsSuccessStatusCode)
            {
                GetReview(id);
                GetReviewList();
                sessionView();

                MessageBox.Show(this.Page, "Successfully, Updated A Review !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Update A Review !");
            }
        }

        private void DeleteReview(int id)
        {
            string url = "http://localhost:56681/api/MegaReview/" + id;
            HttpResponseMessage response = client.DeleteAsync(url).Result;
            response.EnsureSuccessStatusCode();

            if (response.IsSuccessStatusCode)
            {
                clear();
                GetReviewList();

                if(Convert.ToInt32(Session[reviewerTB.Text]) > 0)
                {
                    Session[reviewerTB.Text] = Convert.ToInt32(Session[reviewerTB.Text]) - 1;
                }

                MessageBox.Show(this.Page, "Successfully, Deleted A Review !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Delete A Review !");
            }
        }

        private void GetReview(int id)
        {
            string url = "http://localhost:56681/api/MegaReview/" + id;
            HttpResponseMessage response = client.GetAsync(url).Result;

            if (response.IsSuccessStatusCode)
            {
                var data = response.Content.ReadAsStringAsync().Result;
                var result = JsonConvert.DeserializeObject<ReviewClass>(data);
                bookList.SelectedValue = Convert.ToString(result.BookId1);
                reviewIdTB.Text = Convert.ToString(result.Id1);
                reviewerTB.Text = result.Reviewer1;
                reviewTB.Text = result.Reviews1;
                ratingList.SelectedValue = Convert.ToString(result.Rating1);
                getNameTBList.SelectedValue = Convert.ToString(result.Id1);

                sessionView();

                MessageBox.Show(this.Page, "Successfully, Get A Review !");
            }
            else
            {
                MessageBox.Show(this.Page, "Sorry, Failed to Get A Review !");
            }

        }

        private void clear()
        {
            reviewIdTB.Text = "";
            reviewerTB.Text = "";
            reviewTB.Text = "";

            viewNumLabe.Text = "Viewer Session #";
            viewNumTB.Text = "";
        }

        private void sessionView()
        {
            if(Session[reviewerTB.Text] != null)
            {
                viewNumLabe.Text = reviewerTB.Text + " Session #";
                viewNumTB.Text = Session[reviewerTB.Text].ToString();
            }
        }

        protected void home_Click(object sender, EventArgs e)
        {
            Server.Transfer("Index.aspx", true);

        }
    }
}
