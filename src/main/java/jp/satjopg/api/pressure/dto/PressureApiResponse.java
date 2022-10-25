package jp.satjopg.api.pressure.dto;

import java.io.Serializable;

/**
 * 気圧取得エンドポイントのレスポンス
 *
 * @param placeName 気圧取得地点の名前
 * @param value 気圧の値
 * @param latitude 気圧取得地点の緯度
 * @param longitude 気圧取得地点の経度
 */
public record PressureApiResponse(
    String placeName,
    Integer value,
    Double latitude,
    Double longitude
) implements Serializable {}
