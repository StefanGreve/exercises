using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data;
using System.Data.SQLite;
using Dapper;

namespace Galaxy
{
	public class Database
	{
		public static IEnumerable<T> LoadModel<T>(string table)
		{
			using IDbConnection connection = new SQLiteConnection(Settings.ConnectionString);
			return connection.Query<T>($"SELECT * FROM {table}", new DynamicParameters());
		}

		public static void InsertModel<T>(T model, string table, string[] properties)
		{
			using IDbConnection connection = new SQLiteConnection(Settings.ConnectionString);
			connection.Execute($"INSERT INTO {table} ({string.Join(",", properties)}) values ({string.Join(",", properties.Select(p => $"@{p}"))})", model);
		}

		public static void ClearTable(string table)
		{
			using IDbConnection connection = new SQLiteConnection(Settings.ConnectionString);
			connection.Execute($"DELETE FROM {table}");
		}

		public static void DropTable(string table)
		{
			using IDbConnection connection = new SQLiteConnection(Settings.ConnectionString);
			connection.Execute($"DROP TABLE {table}");
		}
	}
}
