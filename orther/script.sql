USE [master]
GO
/****** Object:  Database [Perfume]    Script Date: 2/27/2018 11:31:41 PM ******/
CREATE DATABASE [Perfume]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Perfume', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Perfume.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Perfume_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Perfume_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Perfume] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Perfume].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Perfume] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Perfume] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Perfume] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Perfume] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Perfume] SET ARITHABORT OFF 
GO
ALTER DATABASE [Perfume] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Perfume] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Perfume] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Perfume] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Perfume] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Perfume] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Perfume] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Perfume] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Perfume] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Perfume] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Perfume] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Perfume] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Perfume] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Perfume] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Perfume] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Perfume] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Perfume] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Perfume] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Perfume] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Perfume] SET  MULTI_USER 
GO
ALTER DATABASE [Perfume] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Perfume] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Perfume] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Perfume] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Perfume]
GO
/****** Object:  Table [dbo].[Bills]    Script Date: 2/27/2018 11:31:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Bills](
	[BillID] [varchar](10) NOT NULL,
	[SalesID] [varchar](10) NOT NULL,
	[Date] [datetime] NOT NULL,
	[Discount] [int] NULL,
	[VAT] [int] NULL,
	[Payment] [varchar](10) NOT NULL,
	[Total] [int] NOT NULL,
	[CustomerID] [varchar](10) NOT NULL,
	[Status] [bit] NOT NULL,
	[Descript] [nvarchar](100) NULL,
 CONSTRAINT [PK_Bills] PRIMARY KEY CLUSTERED 
(
	[BillID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [varchar](10) NOT NULL,
	[CategoryName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customers](
	[CustomerID] [varchar](10) NOT NULL,
	[CustomerName] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](20) NULL,
	[Gender] [nchar](10) NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DayWork]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DayWork](
	[WorkID] [varchar](20) NOT NULL,
	[UserID] [varchar](10) NOT NULL,
	[DayWork] [bit] NOT NULL,
 CONSTRAINT [PK_DayWork_1] PRIMARY KEY CLUSTERED 
(
	[WorkID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderID] [varchar](11) NOT NULL,
	[BillID] [varchar](10) NOT NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Products]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](10) NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[QuantityAvailable] [int] NOT NULL,
	[Price] [int] NOT NULL,
	[DateImport] [datetime] NULL,
	[ExpireDate] [datetime] NULL,
	[Descript] [nvarchar](50) NULL,
	[CategoryID] [varchar](10) NOT NULL,
	[Volume] [int] NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleID] [varchar](10) NOT NULL,
	[RoleName] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Stores]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Stores](
	[StoreID] [varchar](10) NOT NULL,
	[StoreName] [nvarchar](50) NOT NULL,
	[StorePhone] [varchar](20) NULL,
	[StoreAddress] [nvarchar](50) NULL,
	[StoreRent] [int] NULL,
 CONSTRAINT [PK_Stores] PRIMARY KEY CLUSTERED 
(
	[StoreID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [varchar](10) NOT NULL,
	[Username] [varchar](20) NOT NULL,
	[Password] [varchar](20) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](20) NULL,
	[RoleID] [varchar](10) NOT NULL,
	[StoreID] [varchar](10) NULL,
	[Salary] [int] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[View_Bills]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_Bills]
AS
SELECT DISTINCT dbo.Bills.BillID, dbo.Stores.StoreName, dbo.Customers.CustomerName, dbo.Users.Name AS Sales, dbo.Bills.Total, dbo.Bills.Date, dbo.Bills.Status, dbo.Bills.Descript
FROM            dbo.Bills INNER JOIN
                         dbo.OrderDetails ON dbo.Bills.BillID = dbo.OrderDetails.BillID INNER JOIN
                         dbo.Users ON dbo.Bills.SalesID = dbo.Users.UserID INNER JOIN
                         dbo.Stores ON dbo.Users.StoreID = dbo.Stores.StoreID INNER JOIN
                         dbo.Customers ON dbo.Bills.CustomerID = dbo.Customers.CustomerID

GO
/****** Object:  View [dbo].[View_BillSales]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_BillSales]
AS
SELECT        dbo.Bills.BillID, dbo.Bills.Date, dbo.Bills.Total, dbo.Customers.CustomerName, dbo.Bills.SalesID, dbo.Bills.Status
FROM            dbo.Bills INNER JOIN
                         dbo.Customers ON dbo.Bills.CustomerID = dbo.Customers.CustomerID

GO
/****** Object:  View [dbo].[View_Manager]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_Manager]
AS
SELECT        dbo.Users.UserID, dbo.Users.Name, dbo.Users.Phone, dbo.Users.Email, dbo.Stores.StoreName, dbo.Users.Salary, dbo.Roles.RoleName
FROM            dbo.Stores INNER JOIN
                         dbo.Users ON dbo.Stores.StoreID = dbo.Users.StoreID INNER JOIN
                         dbo.Roles ON dbo.Users.RoleID = dbo.Roles.RoleID

GO
/****** Object:  View [dbo].[View_ProductEmpty]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ProductEmpty]
AS
SELECT        dbo.Products.ProductID, dbo.Products.ProductName, dbo.Categories.CategoryName, dbo.Products.DateImport, dbo.Products.ExpireDate, dbo.Products.QuantityAvailable
FROM            dbo.Categories INNER JOIN
                         dbo.Products ON dbo.Categories.CategoryID = dbo.Products.CategoryID

GO
/****** Object:  View [dbo].[View_ProductExpire]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ProductExpire]
AS
SELECT        dbo.Products.ProductID, dbo.Products.ProductName, dbo.Categories.CategoryName, dbo.Products.QuantityAvailable, dbo.Products.DateImport, dbo.Products.ExpireDate
FROM            dbo.Categories INNER JOIN
                         dbo.Products ON dbo.Categories.CategoryID = dbo.Products.CategoryID

GO
/****** Object:  View [dbo].[View_ProductSales]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ProductSales]
AS
SELECT        dbo.Products.ProductID, dbo.Products.ProductName, dbo.Products.QuantityAvailable, dbo.Products.Price, dbo.Products.ExpireDate, dbo.Products.Descript, dbo.Categories.CategoryName, dbo.Products.Volume
FROM            dbo.Categories INNER JOIN
                         dbo.Products ON dbo.Categories.CategoryID = dbo.Products.CategoryID

GO
/****** Object:  View [dbo].[View_ProductSold]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ProductSold]
AS
SELECT        dbo.Products.ProductID, dbo.Products.ProductName, dbo.Categories.CategoryName, dbo.Products.QuantityAvailable, dbo.OrderDetails.Quantity AS Sold, dbo.Bills.Date
FROM            dbo.Products INNER JOIN
                         dbo.OrderDetails ON dbo.Products.ProductID = dbo.OrderDetails.ProductID INNER JOIN
                         dbo.Bills ON dbo.OrderDetails.BillID = dbo.Bills.BillID INNER JOIN
                         dbo.Categories ON dbo.Products.CategoryID = dbo.Categories.CategoryID


GO
/****** Object:  View [dbo].[View_Sales]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_Sales]
AS
SELECT        dbo.Users.UserID, dbo.Users.Name, dbo.Users.Phone, dbo.Users.Email, dbo.Roles.RoleName AS Position, dbo.Users.Salary, dbo.Stores.StoreName
FROM            dbo.Users INNER JOIN
                         dbo.Stores ON dbo.Users.StoreID = dbo.Stores.StoreID INNER JOIN
                         dbo.Roles ON dbo.Users.RoleID = dbo.Roles.RoleID

GO
/****** Object:  View [dbo].[View_Trantract]    Script Date: 2/27/2018 11:31:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_Trantract]
AS
SELECT        dbo.Bills.Date, dbo.OrderDetails.Quantity
FROM            dbo.Bills INNER JOIN
                         dbo.OrderDetails ON dbo.Bills.BillID = dbo.OrderDetails.BillID

GO
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B1', N'ST1SL1', CAST(0x0000A88B00CDF129 AS DateTime), 10, 10, N'Visa', 500000, N'CU1', 1, NULL)
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B3', N'ST1SL1', CAST(0x0000A88F00000000 AS DateTime), 0, 1, N'Cash', 0, N'CU1', 0, N'123')
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B4', N'ST1SL1', CAST(0x0000A88F00000000 AS DateTime), 0, 1, N'Cash', 0, N'CU1', 0, N'123')
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B5', N'ST1SL1', CAST(0x0000A88F00000000 AS DateTime), 0, 1, N'Cash', 600000, N'CU1', 1, NULL)
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B6', N'ST1SL1', CAST(0x0000A88F00000000 AS DateTime), 0, 1, N'Cash', 200000, N'CU1', 1, NULL)
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B8', N'ST1SL1', CAST(0x0000A89300000000 AS DateTime), 0, 10, N'Cash', 400000, N'CU1', 1, NULL)
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status], [Descript]) VALUES (N'ST1SL1B9', N'ST1SL1', CAST(0x0000A89300000000 AS DateTime), 0, 10, N'Cash', 200000, N'CU1', 1, NULL)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA1', N'Adidas')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA11', N't7')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA2', N'Aigner')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA4', N'Alaia')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA5', N't1')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA6', N't2')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA7', N't3')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA8', N't4')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA9', N't5')
INSERT [dbo].[Customers] ([CustomerID], [CustomerName], [Address], [Phone], [Email], [Gender]) VALUES (N'CU1', N'Khanh Long', N'Quan 5', N'09876543321', N'long@gmail.com', N'male      ')
INSERT [dbo].[Customers] ([CustomerID], [CustomerName], [Address], [Phone], [Email], [Gender]) VALUES (N'CU2', N'as', N'asssss', N'0134456789', N'asssss@gmail.com', N'Female    ')
INSERT [dbo].[DayWork] ([WorkID], [UserID], [DayWork]) VALUES (N'02/26/18', N'ST1SL1', 1)
INSERT [dbo].[DayWork] ([WorkID], [UserID], [DayWork]) VALUES (N'02/27/18', N'ST1SL1', 1)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'2', N'ST1SL1B1', N'CA2PD1', 12, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B101', N'ST1SL1B9', N'CA1PD1', 4, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B102', N'ST1SL1B9', N'CA2PD1', 2, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B10O1', N'ST1SL1B9', N'CA1PD1', 1, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B10O2', N'ST1SL1B9', N'CA1PD1', 2, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B17O1', N'ST1SL1B9', N'CA2PD1', 1, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B17O2', N'ST1SL1B9', N'CA1PD1', 2, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B1O1', N'ST1SL1B1', N'CA1PD1', 2, 400000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B1O2', N'ST1SL1B1', N'CA2PD1', 1, 100000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B3O1', N'ST1SL1B3', N'CA1PD1', 0, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B3O2', N'ST1SL1B3', N'CA2PD1', 0, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B4O1', N'ST1SL1B4', N'CA1PD1', 0, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B4O2', N'ST1SL1B4', N'CA2PD1', 0, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B5O1', N'ST1SL1B5', N'CA1PD1', 2, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B5O2', N'ST1SL1B5', N'CA2PD1', 1, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B6O1', N'ST1SL1B6', N'CA1PD1', 1, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B8O1', N'ST1SL1B8', N'CA2PD1', 2, 200000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B9O1', N'ST1SL1B9', N'CA1PD1', 1, 200000)
INSERT [dbo].[Products] ([ProductID], [ProductName], [QuantityAvailable], [Price], [DateImport], [ExpireDate], [Descript], [CategoryID], [Volume]) VALUES (N'CA1PD1', N'Victory League', 7, 200000, CAST(0x0000A88E00000000 AS DateTime), CAST(0x0000A88C00000000 AS DateTime), N'Mô tả 1', N'CA1', 10)
INSERT [dbo].[Products] ([ProductID], [ProductName], [QuantityAvailable], [Price], [DateImport], [ExpireDate], [Descript], [CategoryID], [Volume]) VALUES (N'CA1PD2', N'Nuoc Hoa Ba Chi', 30, 200000, CAST(0x0000A88E00000000 AS DateTime), CAST(0x0000A88B00000000 AS DateTime), N'Mô tả 3', N'CA1', 10)
INSERT [dbo].[Products] ([ProductID], [ProductName], [QuantityAvailable], [Price], [DateImport], [ExpireDate], [Descript], [CategoryID], [Volume]) VALUES (N'CA2PD1', N'Pure Lightness', 0, 200000, CAST(0x0000A89400000000 AS DateTime), CAST(0x0000A8A900000000 AS DateTime), N'Mô tả update', N'CA2', 11)
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'DI', N'Director')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'IV', N'Inventory')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'MN', N'Manager')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'SL', N'Sales')
INSERT [dbo].[Stores] ([StoreID], [StoreName], [StorePhone], [StoreAddress], [StoreRent]) VALUES (N'ST1', N'Chi nhanh 1', N'0123456789', N'Tran Duy Hung', 10000000)
INSERT [dbo].[Stores] ([StoreID], [StoreName], [StorePhone], [StoreAddress], [StoreRent]) VALUES (N'ST4', N'tt', N'tt', N'tt', 23)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'DI1', N'vu', N'vu', N'Tuấn Vũ', N'0123456789', N'vu@gmail.com', N'DI', N'ST1', 5000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'IV1', N'trung', N'trung', N'Quang Trung', N'0123456789', N'trung@gmail.com', N'IV', N'ST1', 1000000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'IV3', N'asss', N'ass', N'ass', N'0123456789', N'ass@gmail.com', N'IV', N'ST1', 20000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'ST1MN', N'test', N'test', N'test', N'0123456789', N'test@gmail.com', N'MN', N'ST1', 20000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'ST1MN1', N'long', N'long', N'Khánh Long', N'0123456879', N'long1@gmail.com', N'MN', N'ST1', 2000000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'ST1SL1', N'tuan', N'tuan', N'Minh Tuấn', N'0123456789', N'tuan@gmail.com', N'SL', N'ST1', 5000000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Name], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'ST1SL2', N'as', N'as', N'as', N'0123456789', N'as@gmai.com', N'SL', N'ST1', 123)
ALTER TABLE [dbo].[Bills] ADD  CONSTRAINT [DF_Bills_Discount]  DEFAULT ((0)) FOR [Discount]
GO
ALTER TABLE [dbo].[Bills] ADD  CONSTRAINT [DF_Bills_VAT]  DEFAULT ((10)) FOR [VAT]
GO
ALTER TABLE [dbo].[Bills] ADD  CONSTRAINT [DF_Bills_Status]  DEFAULT ((1)) FOR [Status]
GO
ALTER TABLE [dbo].[DayWork] ADD  CONSTRAINT [DF_DayWork_DayWork]  DEFAULT ((0)) FOR [DayWork]
GO
ALTER TABLE [dbo].[Stores] ADD  CONSTRAINT [DF_Stores_StoreRent]  DEFAULT ((0)) FOR [StoreRent]
GO
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [DF_Users_Salary]  DEFAULT ((0)) FOR [Salary]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Customers] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customers] ([CustomerID])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Customers]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Users] FOREIGN KEY([SalesID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Users]
GO
ALTER TABLE [dbo].[DayWork]  WITH CHECK ADD  CONSTRAINT [FK_DayWork_Users] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[DayWork] CHECK CONSTRAINT [FK_DayWork_Users]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Bills] FOREIGN KEY([BillID])
REFERENCES [dbo].[Bills] ([BillID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Bills]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Products]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Roles] ([RoleID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Stores] FOREIGN KEY([StoreID])
REFERENCES [dbo].[Stores] ([StoreID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Stores]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[43] 4[5] 2[23] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Bills"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 259
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 1
         End
         Begin Table = "OrderDetails"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 176
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Stores"
            Begin Extent = 
               Top = 180
               Left = 246
               Bottom = 310
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Users"
            Begin Extent = 
               Top = 6
               Left = 454
               Bottom = 242
               Right = 624
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Customers"
            Begin Extent = 
               Top = 6
               Left = 662
               Bottom = 136
               Right = 835
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         T' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Bills'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'able = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Bills'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Bills'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[48] 4[27] 2[7] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Bills"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 274
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Customers"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 192
               Right = 419
            End
            DisplayFlags = 280
            TopColumn = 2
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_BillSales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_BillSales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Stores"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 260
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Users"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 283
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Roles"
            Begin Extent = 
               Top = 6
               Left = 454
               Bottom = 102
               Right = 624
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Manager'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Manager'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Categories"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 221
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Products"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 265
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductEmpty'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductEmpty'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Categories"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 239
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Products"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 246
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductExpire'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductExpire'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[65] 4[9] 2[8] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Categories"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 200
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Products"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 223
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductSales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductSales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Products"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 311
               Right = 221
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "OrderDetails"
            Begin Extent = 
               Top = 6
               Left = 259
               Bottom = 218
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Bills"
            Begin Extent = 
               Top = 6
               Left = 467
               Bottom = 243
               Right = 637
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Categories"
            Begin Extent = 
               Top = 6
               Left = 675
               Bottom = 102
               Right = 845
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 2310
         Alias = 900
         Table = 1170
         Output = 750
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductSold'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductSold'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ProductSold'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Users"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 227
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Stores"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 208
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Roles"
            Begin Extent = 
               Top = 6
               Left = 454
               Bottom = 102
               Right = 624
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Sales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Sales'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[29] 4[29] 2[6] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Bills"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 241
               Right = 212
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "OrderDetails"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 243
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 2775
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Trantract'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_Trantract'
GO
USE [master]
GO
ALTER DATABASE [Perfume] SET  READ_WRITE 
GO
