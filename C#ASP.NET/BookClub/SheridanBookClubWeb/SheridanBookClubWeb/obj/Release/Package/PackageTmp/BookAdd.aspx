<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BookAdd.aspx.cs" Inherits="SheridanBookClubWeb.BookAdd" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Sheridan Book Club</title>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/bootstrap-theme.min.css" rel="stylesheet" />
    <script src="Scripts/jquery-1.9.1.min.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>
    </head>
<body style="margin-left: 4%;">
    <form id="form1" runat="server">
    <div class="container" style="padding: 1%;">
      <h1>Sheridan Book Club - Book</h1><br />
      <div class="form-horizontal">
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-1 label label-warning" for="idTB" ID="Label4" runat="server" Text="Book ID"></asp:Label>
            </h3>
            <div class="col-sm-5">
                <asp:TextBox class="form-control" ID="idTB" runat="server" Enabled="False" Width="264px"></asp:TextBox>
                <asp:Button class="btn btn-info" ID="clearField" runat="server" Text="Clear Field" AutoPostBack="True" ToolTip="Click To Clear All Field" OnClick="clearField_Click" />
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-1 label label-warning" for="nameTB" ID="Label1" runat="server" Text="Name"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="nameTB" runat="server" TextMode="MultiLine"></asp:TextBox>
            </div>
        </div>
        <div class="form-group">
            <h3>
                <asp:Label class="col-sm-1 label label-success" for="releaseTB" ID="Label2" runat="server" Text="Release"></asp:Label>
            </h3>
            <div class="col-sm-5">
                <asp:Calendar ID="releaseCalendar" runat="server" OnSelectionChanged="Calendar1_SelectionChanged" BackColor="#FFFFCC" BorderColor="#FFCC66" BorderWidth="1px" DayNameFormat="Shortest" Font-Names="Verdana" Font-Size="8pt" ForeColor="#663399" Height="200px" ShowGridLines="True" Width="268px">
                    <DayHeaderStyle BackColor="#FFCC66" Font-Bold="True" Height="1px" />
                    <NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC" />
                    <OtherMonthDayStyle ForeColor="#CC9966" />
                    <SelectedDayStyle BackColor="#CCCCFF" Font-Bold="True" />
                    <SelectorStyle BackColor="#FFCC66" />
                    <TitleStyle BackColor="#990000" Font-Bold="True" Font-Size="9pt" ForeColor="#FFFFCC" />
                    <TodayDayStyle BackColor="#FFCC66" ForeColor="White" />
                </asp:Calendar><br />
                <asp:TextBox class="col-sm-7 label label-default" ID="dateTB" runat="server" Font-Size="15px" Height="25px" width="270px" Enabled="False"></asp:TextBox>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-1 label label-primary" for="isbnTB" ID="Label3" runat="server" Text="ISBN-10"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="isbnTB" runat="server" ToolTip="10 Digits Only" ControlToValidate="isbnTB"></asp:TextBox>
                <asp:RegularExpressionValidator ID="isbnValidator" runat="server"
                    ErrorMessage="Book ISBN must be 10 nonblank digits"
                    ValidationExpression="\d{10}"
                    Display="Dynamic"
                    ControlToValidate="isbnTB"
                    ForeColor="Red"></asp:RegularExpressionValidator>
            </div>
        </div>
      </div><hr />
      <div class="conatiner">
          <asp:Button class="btn btn-default" ID="home" runat="server" Text="Go Home" AutoPostBack="True" OnClick="home_Click" ToolTip="Click To Go Home" />
          <asp:Button class="btn btn-danger" ID="addBtn" runat="server" Text="Add New Book" AutoPostBack="True" OnClick="addBtn_Click" ToolTip="Click To Add A New Book" />
          <asp:Button class="btn btn-info" ID="updateBtn" runat="server" Text="Update Book" AutoPostBack="True" OnClick="updateBtn_Click" ToolTip="Click To Update A Book" />
          <asp:Button class="btn btn-warning" ID="deleteBtn" runat="server" Text="Delete Book" AutoPostBack="True" OnClick="deleteBtn_Click" ToolTip="Click To Delete A Book" />
          <asp:Button class="btn btn-success" ID="getBtn" runat="server" Text="Get Book" AutoPostBack="True" OnClick="getBtn_Click" ToolTip="Click To Get A Book To View After Choosing Book ID"/>
          <asp:DropDownList class="btn btn-default dropdown-toggle" ID="getIdList" runat="server" AutoPostBack="True" Height="30px" Width="284px" OnSelectedIndexChanged="getIdList_SelectedIndexChanged" ToolTip="Select A Book ID To Get" ></asp:DropDownList>
      </div>
    </div>
    </form>
</body>
</html>
