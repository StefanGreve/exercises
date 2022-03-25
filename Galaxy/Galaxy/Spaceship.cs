using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy
{
	public class Spaceship
	{
		public string Name { get; set; }

		public string Captain { get; set; }

		public int YearsOfService { get; set; }

		public double PowerSupply { get; set; } = 100;

		public double ProtectiveShield { get; set; } = 100;

		public double LifeSupportShield { get; set; } = 100;

		public double Shell { get { return (ProtectiveShield + LifeSupportShield) / 2; } }

		public int Hits { get; set; } = 0;

		public List<Weapon> Weapons { get; set; } = new List<Weapon>();

		public List<Cargo> Cargos { get; set; } = new List<Cargo>();

		public Spaceship(string name, string captain, int firstYearOfService)
		{
			Name = name;
			Captain = captain;
			YearsOfService = DateTime.Now.Year - firstYearOfService;
		}

		public void SendMessage(string message)
		{
			Database.InsertModel<Message>(new(message, Name), table: "Message", properties: new[] { "Content", "Sender", "Created" });
		}

		public IEnumerable<Message> ReceiveMessages() => Database.LoadModel<Message>(table: "Message");

		public List<string> GetLogBook()
		{
			throw new NotImplementedException();
		}

		public void Attack(Spaceship target, int index)
		{
			Random random = new Random();

			try
			{
				Weapon weapon = Weapons[index];

				if (weapon.Count > 0)
				{
					if (random.Next(0, 101) <= weapon.Accuracy)
					{
						target.ProtectiveShield -= weapon.Damage;
						target.LifeSupportShield -= weapon.PiercingDamage ? weapon.Damage : 0;
						target.Hits++;
					}
					weapon.Count--;
				}
			}
			catch (IndexOutOfRangeException exception)
			{
				Console.Error.WriteLine(exception.Message);
			}
		}

		public void RequestRepair(bool powerSupply, bool protectiveShield, bool lifeSupportShield, int androidCount)
		{
			throw new NotImplementedException();
		}
	}
}
