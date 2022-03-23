using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Galaxy
{
	public class Cargo : IEquatable<Cargo>
	{
		public string Name { get; set; }

		public double Weight { get; set; }

		public int Count { get; set; }

		public Cargo(string name, double weight, int count)
		{
			Name = name;
			Weight = weight;
			Count = count;
		}

		public double GetTotalWeight() => Weight * Count;

		public override bool Equals(object? obj) => (obj is Cargo other) && Equals(other);

		public bool Equals(Cargo? other)
		{
			if (other is null) return false;

			if (ReferenceEquals(this, other)) return true;
			
			return (Name == other.Name && Weight == other.Weight);
		}

		public static bool operator ==(Cargo lhs, Cargo rhs) => lhs.Equals(rhs);

		public static bool operator !=(Cargo lhs, Cargo rhs) => !lhs.Equals(rhs);

		public override int GetHashCode() => HashCode.Combine(Name, Weight);
	}
}
