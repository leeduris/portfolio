<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ReviewView.aspx.cs" Inherits="SheridanBookClubWeb.ReviewView" %>

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
      <h1>Sheridan Book Club - Search</h1><br />
      <div class="form-horizontal">
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-warning" for="bookNameList" ID="Label4" runat="server" Text="Select Book Name" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-5 dropdown">
                <asp:DropDownList class="btn btn-warning dropdown-toggle" ID="bookNameList" runat="server" AutoPostBack="True" Height="30px" Width="416px" OnSelectedIndexChanged="bookNameList_SelectedIndexChanged" ToolTip="Select A Book Name"></asp:DropDownList>
            </div><br /><br />
            <asp:GridView ID="bookNameGridView" runat="server" BackColor="White" BorderColor="#999999" BorderStyle="None" BorderWidth="1px" CellPadding="3" GridLines="Vertical" Height="90px" Width="626px">
                <AlternatingRowStyle BackColor="#DCDCDC" />
                <EditRowStyle HorizontalAlign="Center" VerticalAlign="Middle" />
                <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                <HeaderStyle BackColor="#000084" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <RowStyle BackColor="#EEEEEE" ForeColor="Black" />
                <SelectedRowStyle BackColor="#008A8C" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#0000A9" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#000065" />
            </asp:GridView>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-success" for="bookIdList" ID="Label1" runat="server" Text="Select Book ID" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-5 dropdown">
                <asp:DropDownList class="btn btn-success dropdown-toggle" ID="bookIdList" runat="server" AutoPostBack="True" Height="30px" Width="416px" OnSelectedIndexChanged="bookIdList_SelectedIndexChanged" ToolTip="Select A Book ID"></asp:DropDownList>
            </div><br /><br />
            <asp:GridView ID="bookIdGridView" runat="server" BackColor="White" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px" CellPadding="3" GridLines="Vertical" Height="90px" Width="626px" ForeColor="Black">
                <AlternatingRowStyle BackColor="#CCCCCC" />
                <EditRowStyle HorizontalAlign="Center" VerticalAlign="Middle" />
                <FooterStyle BackColor="#CCCCCC" />
                <HeaderStyle BackColor="Black" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#808080" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#383838" />
            </asp:GridView>
        </div>
        <div class="form-group has-success has-feedback">
            <h3>
                <asp:Label class="col-sm-2 label label-info" for="reviewerList" ID="Label2" runat="server" Text="Select Reviewer" Height="30px"></asp:Label>
            </h3>
            <div class="col-sm-5 dropdown">
                <asp:DropDownList class="btn btn-info dropdown-toggle" ID="reviewerList" runat="server" AutoPostBack="True" Height="30px" Width="416px" OnSelectedIndexChanged="reviewerList_SelectedIndexChanged" ToolTip="Select A Reviewer"></asp:DropDownList>
            </div><br /><br />
            <asp:GridView ID="reviewerGridView" runat="server" BackColor="White" BorderColor="#CC9966" BorderStyle="None" BorderWidth="1px" CellPadding="4" Height="90px" Width="626px">
                <EditRowStyle HorizontalAlign="Center" VerticalAlign="Middle" />
                <FooterStyle BackColor="#FFFFCC" ForeColor="#330099" />
                <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="#FFFFCC" />
                <PagerStyle BackColor="#FFFFCC" ForeColor="#330099" HorizontalAlign="Center" />
                <RowStyle BackColor="White" ForeColor="#330099" />
                <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="#663399" />
                <SortedAscendingCellStyle BackColor="#FEFCEB" />
                <SortedAscendingHeaderStyle BackColor="#AF0101" />
                <SortedDescendingCellStyle BackColor="#F6F0C0" />
                <SortedDescendingHeaderStyle BackColor="#7E0000" />
            </asp:GridView>
        </div>
      </div><hr />
      <div class="conatiner">
          <asp:Button class="btn btn-warning" ID="home" runat="server" Text="Go Home" AutoPostBack="True" OnClick="home_Click" ToolTip="Click To Go Home" />
      </div>
    </div>
    </form>
</body>
</html>
