package tn.esprit.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Trip;
import tn.esprit.entities.User;
import tn.esprit.repositories.EmployeeRepository;
import tn.esprit.repositories.TripRepository;

@Service
@Slf4j
public class TripSerivceImp implements ITripService {

	private final TripRepository tripRepository;

	private final EmployeeRepository employeeRepository;

	public TripSerivceImp(TripRepository tripRepository, EmployeeRepository employeeRepository) {
		this.tripRepository = tripRepository;
		this.employeeRepository = employeeRepository;
	}

	public List<Trip> getAllTrip() {
		return tripRepository.findAll();
	}

	public Trip AddTrip(Trip trip) {
		tripRepository.save(trip);
		return trip;
	}

	public Trip UpdateTrip(Trip trip) {

		tripRepository.save(trip);
		return trip;
	}

	public void DeleteTrip(int id) {
		tripRepository.delete(tripRepository.getById(id));
	}

	public Trip FindTripById(int id) {
		return tripRepository.findById(id).get();
	}

	public void NoterVoyage(Trip trip, Float attrib) {

		trip.setAttribution(attrib);
		Float total = trip.getTotalattribution() + attrib;
		trip.setTotalattribution(total);
		// Float comp=trip.getCompteur()+1;
		trip.setCompteur(trip.getCompteur() + 1);
		Float moy = trip.getTotalattribution() / trip.getCompteur();
		trip.setNote(null);
		trip.setNote(moy);
		if (moy <= 1.9 & moy >= 1.0) {
			trip.setRating("*");
		}

		if (moy <= 2.9 & moy >= 2.0) {
			trip.setRating("* *");
		}

		if (moy <= 3.9 & moy >= 3.0) {
			trip.setRating("* * *");
		}

		if (moy <= 4.9 & moy >= 4.0) {
			trip.setRating("* * * *");
		}
		if (moy >= 5.0) {
			trip.setRating("* * * * *");
		}

		tripRepository.save(trip);

	}

	@Override
	public Trip AddUserToTrip(int employee, int idtrip) {
		// TODO Auto-generated method stub
		Trip trip = tripRepository.findById(idtrip).orElse(null);

		Employee emp = employeeRepository.findById(employee).get();
		emp.setTrip(trip);
		log.info(emp.toString());
		employeeRepository.save(emp);

		return trip;
	}

}
