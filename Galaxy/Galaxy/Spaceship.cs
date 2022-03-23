using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy
{
	public class Spaceship
	{
		public string Captain { get; set; }

		public int YearsOfService { get; set; }

		public double PowerSupply { get; set; } = 100;

		public double ProtectiveShield { get; set; } = 100;

		public double LifeSupportShield { get; set; } = 100;

		public double Shell { get; set; } = 100;

		public int Hits { get; set; } = 0;

		public List<Weapon> Weapons { get; set; } = new List<Weapon>();

		public List<Cargo> Cargos { get; set; } = new List<Cargo>();

		public Spaceship(string captain, int firstYearOfService)
		{
			Captain = captain;
			YearsOfService = DateTime.Now.Year - firstYearOfService;
		}

		public void SendMessage(string message)
		{
			throw new NotImplementedException();
		}

		public List<string> GetLogBook()
		{
			throw new NotImplementedException();
		}

		public void Attack(Spaceship target, Weapon weapon)
		{
			throw new NotImplementedException();
		}

		public void RequestRepair(bool powerSupply, bool protectiveShield, bool lifeSupportShield, int androidCount)
		{
			throw new NotImplementedException();
		}
	}
}
