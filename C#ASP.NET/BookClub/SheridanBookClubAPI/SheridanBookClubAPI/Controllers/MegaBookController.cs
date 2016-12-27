using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace SheridanBookClubAPI.Controllers
{
    public class MegaBookController : ApiController
    {
        MegaBookDataClassesDataContext db = new MegaBookDataClassesDataContext();

        // GET: api/MegaBook
        public IEnumerable<Book> Get()
        {
            var result = db.Books;

            return result;
        }

        // GET: api/MegaBook/5
        public Book Get(int id)
        {
            Book result = new Book();
            var selected = from a in db.Books where a.Id == id select a;
            foreach (Book i in selected)
            {
                result = i;
            }
            return result;
        }

        // POST: api/MegaBook
        public Book Post([FromBody]Book newBook)
        {
            Book result = new Book();
            result.Name = newBook.Name;
            result.ReleaseDate = newBook.ReleaseDate;
            result.ISBN = newBook.ISBN;

            db.Books.InsertOnSubmit(result);
            db.SubmitChanges();

            return result;
        }

        // PUT: api/MegaBook/5
        public Book Put(int id, [FromBody]Book updatedBook)
        {
            Book result = new Book();
            var selected = from a in db.Books where a.Id == id select a;
            foreach(Book i in selected)
            {
                result = i;
            }
            result.Name = updatedBook.Name;
            result.ReleaseDate = updatedBook.ReleaseDate;
            result.ISBN = updatedBook.ISBN;

            db.SubmitChanges();

            return result;
        }

        // DELETE: api/MegaBook/5
        public void Delete(int id)
        {
            Book result = new Book();
            var selected = from a in db.Books where a.Id == id select a;
            foreach(Book i in selected)
            {
                result = i;
            }
            db.Books.DeleteOnSubmit(result);
            db.SubmitChanges();
        }
    }
}
