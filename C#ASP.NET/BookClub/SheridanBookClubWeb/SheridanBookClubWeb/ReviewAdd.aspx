<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ReviewAdd.aspx.cs" Inherits="SheridanBookClubWeb.ReviewAdd" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Sheridan Book Club</title>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/bootstrap-theme.min.css" rel="stylesheet" />
    <script src="Scripts/jquery-1.9.1.min.js"></script>
    <script src="Scripts/bootstrap.min.js"></script>
</head>
<body>
    <form id="form1" runat="server">
    <div class="container" style="padding: 1%;">
      <h1>Sheridan Book Club - Review</h1><br />
      <div class="form-horizontal">
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-warning" for="idTB" ID="Label4" runat="server" Text="Select Book" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-5 dropdown" >
                <asp:DropDownList class="btn btn-warning dropdown-toggle" ID="bookList" runat="server" AutoPostBack="True" Height="30px" Width="416px" OnSelectedIndexChanged="bookList_SelectedIndexChanged" ToolTip="Select A Book Name To View"></asp:DropDownList>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-default" for="reviewIdTB" ID="Label3" runat="server" Text="Review ID" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="reviewIdTB" runat="server" Width="40px" Height="30px" Enabled="False"></asp:TextBox>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-info" for="reviewerTB" ID="Label2" runat="server" Text="Reviewer" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="reviewerTB" runat="server" Width="416px" Height="30px"></asp:TextBox>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-primary" for="reviewTB" ID="Label1" runat="server" Text="Review" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="reviewTB" runat="server" Width="416px" Height="90px" TextMode="MultiLine"></asp:TextBox>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-success" for="RatingList" ID="Label5" runat="server" Text="Rating" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-5 dropdown" >
                <asp:DropDownList class="btn btn-success dropdown-toggle" ID="ratingList" runat="server" AutoPostBack="True" Height="30px" Width="65px" ToolTip="Choose Rating">
                    <asp:ListItem>1</asp:ListItem>
                    <asp:ListItem Value="2"></asp:ListItem>
                    <asp:ListItem Value="3"></asp:ListItem>
                    <asp:ListItem Value="4"></asp:ListItem>
                    <asp:ListItem Value="5"></asp:ListItem>
                    <asp:ListItem Value="6"></asp:ListItem>
                    <asp:ListItem Value="7"></asp:ListItem>
                    <asp:ListItem Value="8"></asp:ListItem>
                    <asp:ListItem Value="9"></asp:ListItem>
                    <asp:ListItem Value="10"></asp:ListItem>
                </asp:DropDownList>
            </div>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-default" for="postBackTB" ID="Label6" runat="server" Text="PostBack Count" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="postBackTB" runat="server" Width="40px" Height="30px" Enabled="False"></asp:TextBox>
            </div>&nbsp;&nbsp;
            <h3>
                <asp:Label class="col-sm-2 label label-default" for="viewNumTB" ID="viewNumLabe" runat="server" Text="Viewer Count" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-3">
                <asp:TextBox class="form-control" ID="viewNumTB" runat="server" value="0" Width="40px" Height="30px" Enabled="False"></asp:TextBox>
            </div>
        </div>
      </div><hr />
      <div class="conatiner">
          <asp:Button class="btn btn-default" ID="home" runat="server" Text="Go Home" AutoPostBack="True" OnClick="home_Click" ToolTip="Click To Go Home" />
          <asp:Button class="btn btn-danger" ID="addBtn" runat="server" Text="Add New Review" AutoPostBack="True" OnClick="addBtn_Click" ToolTip="Click To Add A New Review" />
          <asp:Button class="btn btn-info" ID="updateBtn" runat="server" Text="Update Review" AutoPostBack="True" OnClick="updateBtn_Click" ToolTip="Click To Update A Review" />
          <asp:Button class="btn btn-warning" ID="deleteBtn" runat="server" Text="Delete Review" AutoPostBack="True" OnClick="deleteBtn_Click" ToolTip="Click To Delete A Review" />
          <asp:Button class="btn btn-success" ID="getBtn" runat="server" Text="Get Review" OnClick="getBtn_Click" ToolTip="Click To Get A Review After Selecting A Reviewer" />
          <asp:DropDownList class="btn btn-default dropdown-toggle" ID="getNameTBList" runat="server" AutoPostBack="True" Height="30px" Width="106px" OnSelectedIndexChanged="getNameTBList_SelectedIndexChanged" ToolTip="Select A Reviewer" ></asp:DropDownList>

      </div>
    </div>
    </form>
</body>
</html>
