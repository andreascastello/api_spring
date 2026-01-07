Architecture

Controller → Service → Repository → Hibernate → MariaDB

Séparation des rôles
	•	Controller : HTTP, JSON, codes retour
	•	Service : logique métier
	•	Repository : accès DB
	•	Entity : modèle de persistance
	•	DTO : contrat API

Qualité API
	•	Validation Bean Validation (@Valid, @NotBlank, @Email)
	•	Erreurs centralisées (@RestControllerAdvice)
	•	Codes HTTP propres : 400 / 404 / 409 / 201
