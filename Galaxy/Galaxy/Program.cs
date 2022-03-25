using System;

namespace Galaxy
{
	class Program
	{
		static void Main(string[] args)
		{
			Spaceship enterprise = new Spaceship("Enterprise NX-01", "Jonathan Archer", 1995);
			enterprise.SendMessage("Hello, World!");

			IEnumerable<Message> messages = Database.LoadModel<Message>("Message");
			
			foreach (var message in messages.Where(m => m.Sender == enterprise.Name))
			{
				Console.WriteLine($"{message.Id, 3}\t{message.Created}\tMESSAGE {message.Content} FROM {message.Sender}");
			}
		}
	}
}
