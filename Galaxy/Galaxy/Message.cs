using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy.InformationSystem
{
	public class Message
	{
		public int Id { get; set; }

		public string Content { get; set; }

		public string Sender { get; set; }

		public DateTime Created { get; set; } = DateTime.Now;

		public Message()
		{
			// NOTE: This method is used in the Database class
		}

		public Message(string content, string sender)
		{
			Content = content;
			Sender = sender;
		}

	}
}
