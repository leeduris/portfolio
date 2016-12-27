using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace SheridanBookClubAPI.Controllers
{
    public class MegaReviewController : ApiController
    {
        MegaReviewDataClassesDataContext db = new MegaReviewDataClassesDataContext();
        // GET: api/MegaReview
        public IEnumerable<Review> Get()
        {
            var result = db.Reviews;
            return result;
        }

        // GET: api/MegaReview/5
        public Review Get(int id)
        {
            Review result = new Review();
            var selected = from a in db.Reviews where a.Id == id select a;
            foreach(Review i in selected)
            {
                result = i;
            }
            return result;
        }

        // POST: api/MegaReview
        public Review Post([FromBody]Review newReview)
        {
            Review result = new Review();
            result.Reviewer = newReview.Reviewer;
            result.Reviews = newReview.Reviews;
            result.Date = newReview.Date;
            result.Rating = newReview.Rating;
            result.BookID = newReview.BookID;

            db.Reviews.InsertOnSubmit(result);
            db.SubmitChanges();

            return result;
        }

        // PUT: api/MegaReview/5
        public Review Put(int id, [FromBody]Review updatedReview)
        {
            Review result = new Review();
            var selected = from a in db.Reviews where a.Id == id select a;
            foreach(Review i in selected)
            {
                result = i;
            }
            result.Reviewer = updatedReview.Reviewer;
            result.Reviews = updatedReview.Reviews;
            result.Date = updatedReview.Date;
            result.Rating = updatedReview.Rating;
            result.BookID = updatedReview.BookID;

            db.SubmitChanges();

            return result;
        }

        // DELETE: api/MegaReview/5
        public void Delete(int id)
        {
            Review result = new Review();
            var selected = from a in db.Reviews where a.Id == id select a;
            foreach(Review i in selected)
            {
                result = i;
            }
            db.Reviews.DeleteOnSubmit(result);
            db.SubmitChanges();
        }
    }
}
