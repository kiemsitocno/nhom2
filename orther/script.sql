USE [master]
GO
/****** Object:  Database [Perfume]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[Bills]    Script Date: 2/10/2018 03:26:36 PM ******/
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
 CONSTRAINT [PK_Bills] PRIMARY KEY CLUSTERED 
(
	[BillID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[Customers]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[DayWork]    Script Date: 2/10/2018 03:26:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DayWork](
	[WorkID] [int] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 2/10/2018 03:26:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderID] [varchar](10) NOT NULL,
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
/****** Object:  Table [dbo].[Products]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[Roles]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[Stores]    Script Date: 2/10/2018 03:26:36 PM ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 2/10/2018 03:26:36 PM ******/
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
INSERT [dbo].[Bills] ([BillID], [SalesID], [Date], [Discount], [VAT], [Payment], [Total], [CustomerID], [Status]) VALUES (N'ST1SL1B1', N'ST1SL1', CAST(0x0000A88300CDF129 AS DateTime), 10, 10, N'Visa', 500000, N'CU1', 1)
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA1', N'Adidas')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA2', N'Aigner')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA3', N'AirVal')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'CA4', N'Alaia')
INSERT [dbo].[Customers] ([CustomerID], [CustomerName], [Address], [Phone], [Email], [Gender]) VALUES (N'CU1', N'Khanh Long', N'Quan 5', N'09876543321', N'long@gmail.com', N'male      ')
SET IDENTITY_INSERT [dbo].[DayWork] ON 

INSERT [dbo].[DayWork] ([WorkID], [UserID], [DayWork]) VALUES (1, N'ST1SL1', 1)
SET IDENTITY_INSERT [dbo].[DayWork] OFF
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B1O1', N'ST1SL1B1', N'CA1PD1', 2, 400000)
INSERT [dbo].[OrderDetails] ([OrderID], [BillID], [ProductID], [Quantity], [Price]) VALUES (N'ST1SL1B1O2', N'ST1SL1B1', N'CA2PD1', 1, 100000)
INSERT [dbo].[Products] ([ProductID], [ProductName], [QuantityAvailable], [Price], [DateImport], [ExpireDate], [Descript], [CategoryID], [Volume]) VALUES (N'CA1PD1', N'Victory League', 20, 200000, CAST(0x0000A88200CDF129 AS DateTime), CAST(0x0000A88300CDF129 AS DateTime), N'Mô tả 1', N'CA1', 10)
INSERT [dbo].[Products] ([ProductID], [ProductName], [QuantityAvailable], [Price], [DateImport], [ExpireDate], [Descript], [CategoryID], [Volume]) VALUES (N'CA2PD1', N'Pure Lightness', 20, 100000, CAST(0x0000A88300CDF129 AS DateTime), CAST(0x0000A88300CDF129 AS DateTime), N'Mô tả 2', N'CA2', 10)
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'DI', N'Director')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'IV', N'Inventory')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'MN', N'Manager')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'SL', N'Sales')
INSERT [dbo].[Stores] ([StoreID], [StoreName], [StorePhone], [StoreAddress], [StoreRent]) VALUES (N'ST1', N'Chi nhanh 1', N'0123456789', N'Tran Duy Hung', 10000000)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [Phone], [Email], [RoleID], [StoreID], [Salary]) VALUES (N'ST1SL1', N'trung', N'trung', N'0123456789', N'trung@gmail.com', N'SL', N'ST1', 5000000)
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
USE [master]
GO
ALTER DATABASE [Perfume] SET  READ_WRITE 
GO
