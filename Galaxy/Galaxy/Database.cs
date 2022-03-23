using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data;
using System.Data.SQLite;
using Dapper;

namespace Galaxy.InformationSystem
{
	public class Database
	{
		private static string LoadConnectionString(string name = "Default")
		{
			return ConfigurationManager.ConnectionStrings[name].ConnectionString;
		}

		public static List<Message> LoadMessages()
		{
			using IDbConnection connection = new SQLiteConnection(LoadConnectionString());
			var output = connection.Query<Message>("SELECT * FROM Message", new DynamicParameters());
			return output.ToList();
		}

		public static void SendMessage(string content, string sender)
		{
			Message message = new(content, sender);
			using IDbConnection connection = new SQLiteConnection(LoadConnectionString());
			connection.Execute("INSERT INTO Message (Content,Sender,Created) values (@Content,@Sender,@Created)", message);
		}
	}
}
