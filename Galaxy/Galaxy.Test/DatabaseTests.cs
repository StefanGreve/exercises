using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Galaxy;
using Xunit;
using Xunit.Abstractions;

namespace Galaxy.Test
{
	public class DatabaseFixture : IDisposable
	{

		public static readonly string Table = "Message";

		public static readonly string[] Properties = { "Content", "Sender", "Created" };

		public DatabaseFixture()
		{
			Database.InsertModel<Message>(new("Test Message 1", "Hans Solo"), Table, Properties);
			Database.InsertModel<Message>(new("Test Message 2", "Jonathan Archer"), Table, Properties);
		}

		public void Dispose()
		{
			Database.ClearTable(Table);
		}
	}

	[CollectionDefinition("SQLite Database")]
	public class DatabaseCollection : ICollectionFixture<DatabaseFixture>
	{
		// This class has no code, and is never created. Its purpose is simply
		// to be the place to apply [CollectionDefinition] and all the
		// ICollectionFixture<DatabaseaseFixture> interfaces.
	}

	[Collection("SQLite Database")]
	public class DatabaseTests
	{
		private readonly ITestOutputHelper outputHelper;

		public DatabaseTests(ITestOutputHelper outputHelper)
		{
			this.outputHelper = outputHelper;
		}

		[Fact]
		public void ReceiveMessagesTest()
		{
			IEnumerable<Message> messages = Database.LoadModel<Message>(DatabaseFixture.Table);
			messages.ToList().ForEach(m => outputHelper.WriteLine($"{m.Created}\t{m.Content}"));
			Assert.Equal(expected: 2, actual: messages.Count());
		}
	}
}
