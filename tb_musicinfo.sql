CREATE TABLE [dbo].[tb_musicinfo]
(
	 [Music_code]     VARCHAR (50) NOT NULL,
    [Music_name]     VARCHAR (50) NOT NULL,
    [Music_author]   VARCHAR (50) NULL,
    [Music_Kind]     VARCHAR (50) NULL,
    [Music_chinse]   VARCHAR (50) NULL,
    [Music_Ping]     VARCHAR (50) NULL,
    [Music_falg]     INT          NULL,
    [Music_date]     TIME (7)     NULL,
    [Music_filepath] VARCHAR (50) NULL,
    PRIMARY KEY CLUSTERED ([Music_code] ASC)
)
