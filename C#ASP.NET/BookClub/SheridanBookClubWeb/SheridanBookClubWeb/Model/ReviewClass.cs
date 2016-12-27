using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SheridanBookClubWeb.Model
{
    public class ReviewClass
    {
        int Id;
        string Reviewer;
        string Reviews;
        DateTime Date;
        int Rating;
        int BookId;

        public int Id1
        {
            get
            {
                return Id;
            }

            set
            {
                Id = value;
            }
        }

        public string Reviewer1
        {
            get
            {
                return Reviewer;
            }

            set
            {
                Reviewer = value;
            }
        }

        public string Reviews1
        {
            get
            {
                return Reviews;
            }

            set
            {
                Reviews = value;
            }
        }

        public DateTime Date1
        {
            get
            {
                return Date;
            }

            set
            {
                Date = value;
            }
        }

        public int Rating1
        {
            get
            {
                return Rating;
            }

            set
            {
                Rating = value;
            }
        }

        public int BookId1
        {
            get
            {
                return BookId;
            }

            set
            {
                BookId = value;
            }
        }

        public ReviewClass(int id, string reviewer, string reviews, DateTime date, int rating, int bookId)
        {
            Id1 = id;
            Reviewer1 = reviewer;
            Reviews1 = reviews;
            Date1 = date;
            Rating1 = rating;
            BookId1 = bookId;
        }
    }
}
