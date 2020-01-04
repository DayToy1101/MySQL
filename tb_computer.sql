CREATE TABLE [dbo].[tb_computer]
(
	 [cmp_ID]   VARCHAR (20) NOT NULL primary key,
    [cmp_name] VARCHAR (30) NULL,
    [cmp_Paww] VARCHAR (50) NULL,
    [cmp_Falg] INT          NULL,
    PRIMARY KEY CLUSTERED ([cmp_ID] ASC)
)
