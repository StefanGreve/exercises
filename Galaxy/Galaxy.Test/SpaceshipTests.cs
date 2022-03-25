using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Galaxy;
using Xunit;

namespace Galaxy.Test
{
    public class SpaceshipTests
    {
		[Fact]
		public void AttackTest()
		{
			// spaceship 1
			Weapon photonLaser = new("Photon Laser", 30, 100, true, 20);
			Spaceship enterprise = new("Enterprise NX-01", "Jonathan Archer", 1995);
			enterprise.Weapons.Add(photonLaser);
			
			// spaceship 2
			Spaceship falcon = new("Millennium Falcon", "Hans Solo", 1994);

			enterprise.Attack(falcon, 0);

			Assert.Equal(expected: 70, actual: falcon.Shell);
			Assert.Equal(expected: 1, actual: falcon.Hits);
			Assert.Equal(expected: 19, actual: photonLaser.Count);
		}
	}
}
