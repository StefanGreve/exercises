using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy
{
	public class Message
	{
		public int Id { get; set; }

		public string Content { get; set; }

		public string Sender { get; set; }

		public DateTime Created { get; set; } = DateTime.Now;

#pragma warning disable 8618
		public Message()
		{
			// NOTE: This method is used in the Database class
		}
#pragma warning restore 8618

		public Message(string content, string sender)
		{
			Content = content;
			Sender = sender;
		}

	}
}
