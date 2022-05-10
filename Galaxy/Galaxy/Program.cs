using System;

namespace Galaxy
{
	class Program
	{
		static void Main(string[] args)
		{
			#region === Setup Game ===
			Weapon photonLaser = new("Photon Laser", 10, 100, false, 100);
			Weapon photonTorpedo = new("Photon Torpoedo", 30, 60, true, 10);

			Spaceship klingonen = new("Klingonen", "Zickermann", 1980);
			Spaceship romulaner = new("Ramulaner", "Greve", 1995);
			Spaceship vulkanier = new("Vulkanier", "Tenesee", 1975);

			klingonen.Weapons.Add(photonLaser);
			klingonen.Weapons.Add(photonTorpedo);
			romulaner.Weapons.Add(photonLaser);
			#endregion

			#region === Start Game ===
			vulkanier.SendMessage("Violence is not logical!");

			klingonen.GetStatusUpdate();
			klingonen.Cargos.ForEach(cargo => Console.WriteLine(cargo));

			vulkanier.RequestRepair(true, true, true, 3);

			vulkanier.Weapons.Add(photonTorpedo);
			vulkanier.Cargos.Clear();

			klingonen.Attack(romulaner, 1);
			klingonen.Attack(romulaner, 1);

			klingonen.GetStatusUpdate();
			romulaner.GetStatusUpdate();
			vulkanier.GetStatusUpdate();

			klingonen.Cargos.ForEach(cargo => Console.WriteLine(cargo));
			romulaner.Cargos.ForEach(cargo => Console.WriteLine(cargo));
			vulkanier.Cargos.ForEach(cargo => Console.WriteLine(cargo));

			IEnumerable<Message> messages = Database.LoadModel<Message>("Message");

			foreach (var message in messages)
			{
				Console.WriteLine($"{message.Id,3}\t{message.Created}\tMESSAGE {message.Content} FROM {message.Sender}");
			}

			#endregion

			#region End Game

			Database.ClearTable("Message");

			#endregion
		}
	}
}
