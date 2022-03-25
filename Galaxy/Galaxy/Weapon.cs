using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy
{
	public class Weapon : IEquatable<Weapon>
	{
		public bool PiercingDamage { get; private set; }

		public string Name { get; set; }

		public double Damage { get; set; }	

		public double Accuracy { get; set; }

		public int Count { get; set; }

		public Weapon(string name, double damage, double accuracy, bool piercingDamage, int count = 1)
		{
			Name = name;
			Damage = damage;
			Accuracy = accuracy;
			Count = count;
			PiercingDamage = piercingDamage;
		}

		public override bool Equals(object? obj) => (obj is Weapon other) && Equals(other);

		public bool Equals(Weapon? other)
		{
			if (other is null) return false;

			if (ReferenceEquals(this, other)) return true;

			return (Name == other.Name && Damage == other.Damage && Accuracy == other.Accuracy);
		}

		public static bool operator ==(Weapon lhs, Weapon rhs) => lhs.Equals(rhs);

		public static bool operator !=(Weapon lhs, Weapon? rhs) => !lhs.Equals(rhs);

		public override int GetHashCode() => HashCode.Combine(Name, Damage, Accuracy);
	}
}
