#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SheridanBookClubAPI
{
	using System.Data.Linq;
	using System.Data.Linq.Mapping;
	using System.Data;
	using System.Collections.Generic;
	using System.Reflection;
	using System.Linq;
	using System.Linq.Expressions;
	using System.ComponentModel;
	using System;


	[global::System.Data.Linq.Mapping.DatabaseAttribute(Name="SheridanMegaBookView")]
	public partial class MegaReviewDataClassesDataContext : System.Data.Linq.DataContext
	{

		private static System.Data.Linq.Mapping.MappingSource mappingSource = new AttributeMappingSource();

    #region Extensibility Method Definitions
    partial void OnCreated();
    partial void InsertReview(Review instance);
    partial void UpdateReview(Review instance);
    partial void DeleteReview(Review instance);
    #endregion

		public MegaReviewDataClassesDataContext() :
				base(global::System.Configuration.ConfigurationManager.ConnectionStrings["SheridanMegaBookViewConnectionString"].ConnectionString, mappingSource)
		{
			OnCreated();
		}

		public MegaReviewDataClassesDataContext(string connection) :
				base(connection, mappingSource)
		{
			OnCreated();
		}

		public MegaReviewDataClassesDataContext(System.Data.IDbConnection connection) :
				base(connection, mappingSource)
		{
			OnCreated();
		}

		public MegaReviewDataClassesDataContext(string connection, System.Data.Linq.Mapping.MappingSource mappingSource) :
				base(connection, mappingSource)
		{
			OnCreated();
		}

		public MegaReviewDataClassesDataContext(System.Data.IDbConnection connection, System.Data.Linq.Mapping.MappingSource mappingSource) :
				base(connection, mappingSource)
		{
			OnCreated();
		}

		public System.Data.Linq.Table<Review> Reviews
		{
			get
			{
				return this.GetTable<Review>();
			}
		}
	}

	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Review")]
	public partial class Review : INotifyPropertyChanging, INotifyPropertyChanged
	{

		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);

		private int _Id;

		private string _Reviewer;

		private string _Reviews;

		private System.DateTime _Date;

		private System.Nullable<int> _Rating;

		private int _BookID;

    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnReviewerChanging(string value);
    partial void OnReviewerChanged();
    partial void OnReviewsChanging(string value);
    partial void OnReviewsChanged();
    partial void OnDateChanging(System.DateTime value);
    partial void OnDateChanged();
    partial void OnRatingChanging(System.Nullable<int> value);
    partial void OnRatingChanged();
    partial void OnBookIDChanging(int value);
    partial void OnBookIDChanged();
    #endregion

		public Review()
		{
			OnCreated();
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
		public int Id
		{
			get
			{
				return this._Id;
			}
			set
			{
				if ((this._Id != value))
				{
					this.OnIdChanging(value);
					this.SendPropertyChanging();
					this._Id = value;
					this.SendPropertyChanged("Id");
					this.OnIdChanged();
				}
			}
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Reviewer", DbType="VarChar(MAX) NOT NULL", CanBeNull=false)]
		public string Reviewer
		{
			get
			{
				return this._Reviewer;
			}
			set
			{
				if ((this._Reviewer != value))
				{
					this.OnReviewerChanging(value);
					this.SendPropertyChanging();
					this._Reviewer = value;
					this.SendPropertyChanged("Reviewer");
					this.OnReviewerChanged();
				}
			}
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Reviews", DbType="VarChar(MAX) NOT NULL", CanBeNull=false)]
		public string Reviews
		{
			get
			{
				return this._Reviews;
			}
			set
			{
				if ((this._Reviews != value))
				{
					this.OnReviewsChanging(value);
					this.SendPropertyChanging();
					this._Reviews = value;
					this.SendPropertyChanged("Reviews");
					this.OnReviewsChanged();
				}
			}
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Date", DbType="Date NOT NULL")]
		public System.DateTime Date
		{
			get
			{
				return this._Date;
			}
			set
			{
				if ((this._Date != value))
				{
					this.OnDateChanging(value);
					this.SendPropertyChanging();
					this._Date = value;
					this.SendPropertyChanged("Date");
					this.OnDateChanged();
				}
			}
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Rating", DbType="Int")]
		public System.Nullable<int> Rating
		{
			get
			{
				return this._Rating;
			}
			set
			{
				if ((this._Rating != value))
				{
					this.OnRatingChanging(value);
					this.SendPropertyChanging();
					this._Rating = value;
					this.SendPropertyChanged("Rating");
					this.OnRatingChanged();
				}
			}
		}

		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_BookID", DbType="Int NOT NULL")]
		public int BookID
		{
			get
			{
				return this._BookID;
			}
			set
			{
				if ((this._BookID != value))
				{
					this.OnBookIDChanging(value);
					this.SendPropertyChanging();
					this._BookID = value;
					this.SendPropertyChanged("BookID");
					this.OnBookIDChanged();
				}
			}
		}

		public event PropertyChangingEventHandler PropertyChanging;

		public event PropertyChangedEventHandler PropertyChanged;

		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}

		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
}
#pragma warning restore 1591
