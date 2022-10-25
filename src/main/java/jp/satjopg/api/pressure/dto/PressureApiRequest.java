package jp.satjopg.api.pressure.dto;

import java.io.Serializable;

public record PressureApiRequest(Double lat, Double lon) implements Serializable {
}
