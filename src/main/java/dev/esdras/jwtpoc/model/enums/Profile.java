package dev.esdras.jwtpoc.model.enums;

public enum Profile {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENT(2, "ROLE_CLIENT");

    private Integer code;
    private String description;

    Profile(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(Integer code) {
        for (Profile profile : Profile.values()) {
            if (code.equals(profile.getCode())) return profile;
        }
        throw new RuntimeException("Perfil inválido. Código: "+code);
    }
}
