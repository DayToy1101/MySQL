CREATE TABLE [dbo].[tb_authorinfo]
(
	[authorId]       VARCHAR (50)  NOT NULL primary key,
    [authorName]     VARCHAR (50)  NOT NULL,
    [authorSex]      VARCHAR (50)  NOT NULL,
    [authorbirthday] DATETIME2 (7) NULL,
    [authorGenre]    VARCHAR (50)  NULL,
    [authorcompany]  VARCHAR (100) NULL,
    [authorRecma]    VARCHAR (50)  NULL,
    [authorzjm]      VARCHAR (50)  NULL,
    [RdateTime]      TIME (7)      NULL,
    PRIMARY KEY CLUSTERED ([authorId] ASC)
);
