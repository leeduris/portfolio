using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SheridanBookClubWeb.Model
{
    public class BookClass
    {
        int Id;
        string Name;
        DateTime ReleaseDate;
        string Isbn;

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

        public string Name1
        {
            get
            {
                return Name;
            }

            set
            {
                Name = value;
            }
        }

        public DateTime ReleaseDate1
        {
            get
            {
                return ReleaseDate;
            }

            set
            {
                ReleaseDate = value;
            }
        }

        public string Isbn1
        {
            get
            {
                return Isbn;
            }

            set
            {
                Isbn = value;
            }
        }

        public BookClass(int id, string name, DateTime releasedate, string isbn)
        {
            this.Id = id;
            this.Name = name;
            this.ReleaseDate = releasedate;
            this.Isbn = isbn;
        }
    }
}
