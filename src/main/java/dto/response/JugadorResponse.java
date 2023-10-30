package dto.response;

import java.util.List;

import ps.model.Jugador;

public class JugadorResponse {

	private List<Jugador> jugadores;

	public JugadorResponse(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
}
