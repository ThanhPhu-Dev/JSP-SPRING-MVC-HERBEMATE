USE [jspservletjdbc]
GO
/****** Object:  Table [dbo].[category]    Script Date: 2/22/2021 5:00:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[code] [varchar](255) NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [nvarchar](255) NULL,
	[modifiedby] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comment]    Script Date: 2/22/2021 5:00:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [text] NOT NULL,
	[userId] [bigint] NOT NULL,
	[new_id] [bigint] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [varchar](255) NULL,
	[modifiedby] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[news]    Script Date: 2/22/2021 5:00:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[thumbnail] [varchar](255) NULL,
	[shortdescription] [ntext] NULL,
	[content] [ntext] NULL,
	[categoryid] [bigint] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [nvarchar](255) NULL,
	[modifiedby] [nvarchar](255) NULL,
 CONSTRAINT [PK__news__3213E83FF847B29A] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 2/22/2021 5:00:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[code] [varchar](255) NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [nvarchar](255) NULL,
	[modifiedby] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 2/22/2021 5:00:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[fullname] [nvarchar](150) NULL,
	[status] [int] NOT NULL,
	[roleid] [bigint] NOT NULL,
	[createddate] [datetime] NULL,
	[modifieddate] [datetime] NULL,
	[createdby] [nvarchar](255) NULL,
	[modifiedby] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'Thể Thao', N'the-thao', CAST(N'2020-11-23T17:04:08.853' AS DateTime), CAST(N'2020-11-23T17:04:08.853' AS DateTime), NULL, NULL)
INSERT [dbo].[category] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (2, N'Thế Giới', N'the-gioi', CAST(N'2020-11-23T17:04:19.313' AS DateTime), CAST(N'2020-11-23T17:04:19.313' AS DateTime), NULL, NULL)
INSERT [dbo].[category] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (3, N'Chinh Trị', N'chinh-tri', CAST(N'2020-11-23T17:04:30.090' AS DateTime), CAST(N'2020-11-23T17:04:30.090' AS DateTime), NULL, NULL)
INSERT [dbo].[category] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (4, N'Thời Sự', N'thoi-su', CAST(N'2020-11-23T17:04:38.697' AS DateTime), CAST(N'2020-11-23T17:04:38.697' AS DateTime), NULL, NULL)
INSERT [dbo].[category] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (5, N'Góc Nhìn', N'goc-nhin', CAST(N'2020-11-23T17:04:46.393' AS DateTime), CAST(N'2020-11-23T17:04:46.393' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[news] ON 

INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (16, N'Bai Viet 11', NULL, NULL, N'Bai Viet 1', 2, CAST(N'2021-01-29T12:11:27.917' AS DateTime), CAST(N'2021-01-29T12:11:27.917' AS DateTime), NULL, NULL)
INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (17, N'Bai Viet 12', NULL, NULL, N'Bai Viet 1', 1, CAST(N'2021-01-29T17:00:10.413' AS DateTime), CAST(N'2021-01-29T17:00:10.413' AS DateTime), NULL, NULL)
INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (18, N'Bai Viet 13', NULL, NULL, N'Bai Viet 1', 3, CAST(N'2021-01-29T17:25:07.657' AS DateTime), CAST(N'2021-01-29T17:25:07.657' AS DateTime), NULL, NULL)
INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (19, N'Bai Viet 14', NULL, NULL, N'Bai Viet 1', 4, CAST(N'2021-01-29T17:26:50.903' AS DateTime), CAST(N'2021-01-29T17:26:50.903' AS DateTime), NULL, NULL)
INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (20, N'Bai Viet 15', NULL, NULL, N'Bai Viet 1', 2, CAST(N'2021-01-29T17:27:18.050' AS DateTime), CAST(N'2021-01-29T17:27:18.050' AS DateTime), NULL, NULL)
INSERT [dbo].[news] ([id], [title], [thumbnail], [shortdescription], [content], [categoryid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (28, N'thế thao xong bài', N'th? thao xong bài', N'thế thao xong bài', N'<p>ckeditor</p>
', 1, CAST(N'2021-02-22T00:00:00.000' AS DateTime), CAST(N'2021-02-22T16:35:03.557' AS DateTime), N'admin', NULL)
SET IDENTITY_INSERT [dbo].[news] OFF
GO
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'ADMIN', N'ADMIN', CAST(N'2020-11-23T17:03:22.883' AS DateTime), CAST(N'2020-11-23T17:03:22.883' AS DateTime), NULL, NULL)
INSERT [dbo].[role] ([id], [name], [code], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (2, N'USER', N'USER', CAST(N'2020-11-23T17:03:22.910' AS DateTime), CAST(N'2020-11-23T17:03:22.910' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[role] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password], [fullname], [status], [roleid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (1, N'admin', N'123456', N'Admin', 1, 1, CAST(N'2020-11-23T17:03:27.343' AS DateTime), CAST(N'2020-11-23T17:03:27.343' AS DateTime), NULL, NULL)
INSERT [dbo].[users] ([id], [username], [password], [fullname], [status], [roleid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (2, N'user', N'123456', N'nguyen van a', 1, 2, CAST(N'2020-11-23T17:03:27.363' AS DateTime), CAST(N'2020-11-23T17:03:27.363' AS DateTime), NULL, NULL)
INSERT [dbo].[users] ([id], [username], [password], [fullname], [status], [roleid], [createddate], [modifieddate], [createdby], [modifiedby]) VALUES (3, N'nguyenvanb', N'123456', N'nguyen van b', 1, 2, CAST(N'2020-11-23T17:03:27.367' AS DateTime), CAST(N'2020-11-23T17:03:27.367' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[category] ADD  DEFAULT (getdate()) FOR [createddate]
GO
ALTER TABLE [dbo].[category] ADD  DEFAULT (getdate()) FOR [modifieddate]
GO
ALTER TABLE [dbo].[comment] ADD  DEFAULT (getdate()) FOR [createddate]
GO
ALTER TABLE [dbo].[comment] ADD  DEFAULT (getdate()) FOR [modifieddate]
GO
ALTER TABLE [dbo].[news] ADD  CONSTRAINT [DF__news__createddat__403A8C7D]  DEFAULT (getdate()) FOR [createddate]
GO
ALTER TABLE [dbo].[news] ADD  CONSTRAINT [DF__news__modifiedda__412EB0B6]  DEFAULT (getdate()) FOR [modifieddate]
GO
ALTER TABLE [dbo].[role] ADD  DEFAULT (getdate()) FOR [createddate]
GO
ALTER TABLE [dbo].[role] ADD  DEFAULT (getdate()) FOR [modifieddate]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [createddate]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [modifieddate]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [fk_comment_news] FOREIGN KEY([new_id])
REFERENCES [dbo].[news] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [fk_comment_news]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [fk_comment_users] FOREIGN KEY([userId])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [fk_comment_users]
GO
ALTER TABLE [dbo].[news]  WITH CHECK ADD  CONSTRAINT [fk_news_category] FOREIGN KEY([categoryid])
REFERENCES [dbo].[category] ([id])
GO
ALTER TABLE [dbo].[news] CHECK CONSTRAINT [fk_news_category]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [fk_users_role] FOREIGN KEY([roleid])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [fk_users_role]
GO
