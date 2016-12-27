using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;

namespace ShopMall
{
    class DbManager
    {
        public static string connectionString = @"Data Source=sheridancollege.database.windows.net;Initial Catalog=Products;Persist Security Info=True;User ID=stan;Password=SheridanCollege2017";

        public static DataTable view(string table)
        {
            DataTable viewTable = new DataTable();

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();

                string selectSql = "select * from " + table ;

                using (SqlCommand cmd = new SqlCommand(selectSql, conn))
                {
                    SqlDataAdapter adapt = new SqlDataAdapter(cmd);
                    adapt.Fill(viewTable);

                    conn.Close();
                }
            }
            return viewTable;
        }

        public static void addSale(DataTable sale)
        {
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();

                string insertSql = @"Insert into Sales (ProductId, Quantity, Price) values(@productId , @quantity , @price)";

                foreach (DataRow row in sale.Rows)
                {
                    using (SqlCommand cmd = new SqlCommand(insertSql, conn))
                    {
                        cmd.Parameters.AddWithValue("@productId", Int32.Parse(row[1].ToString()));
                        cmd.Parameters.AddWithValue("@quantity", Int32.Parse(row[3].ToString()));
                        cmd.Parameters.AddWithValue("@price", Double.Parse(row[4].ToString()));
                        cmd.ExecuteNonQuery();
                    }
                }
                conn.Close();
            }
        }

        public static void addRating(object[] rate)
        {
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();

                string insertSql = @"Insert into Rating (ProductId, ProductRating, Comment) values(@productId , @rating , @comment)";

                using (SqlCommand cmd = new SqlCommand(insertSql, conn))
                {
                    cmd.Parameters.AddWithValue("@productId", rate[0]);
                    cmd.Parameters.AddWithValue("@rating", rate[1]);
                    cmd.Parameters.AddWithValue("@comment", rate[2]);
                    cmd.ExecuteNonQuery();

                    conn.Close();
                }
            }
        }
    }
}
