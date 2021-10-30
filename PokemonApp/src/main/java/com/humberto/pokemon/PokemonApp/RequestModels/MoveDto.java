package com.humberto.pokemon.PokemonApp.RequestModels;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humberto.pokemon.PokemonApp.Enums.CategoryMove;
import com.humberto.pokemon.PokemonApp.Models.Move;
import com.humberto.pokemon.PokemonApp.Repositories.MoveRepository;

public class MoveDto extends Dto{

	private Long fId;
	@NotBlank
	private String fName;
	@NotBlank
	private String fCategory;
	@NotNull
	@PositiveOrZero
	private Long fPower;
	@NotNull
	@PositiveOrZero
	@Max(100)
	private Integer fAccuracy;
	@NotNull
	@Positive
	private Integer fMinTimesPerTour;
	@Positive
	private Integer fMaxTimesPerTour;
	@NotBlank
	private String fUserFaints;
	@NotNull
	private Integer fRoundsToLoad;
	@NotNull
	@Positive
	private Integer fPp;
	@NotBlank
	private String fTrapping;
	@NotNull
	@PositiveOrZero
	@Max(100)
	private Integer fFlinchingProbability;
	
	public MoveDto(Long fId, @NotBlank String fName, @NotBlank String fCategory, @NotNull @PositiveOrZero Long fPower,
			@NotNull @PositiveOrZero @Max(100) Integer fAccuracy, Integer fMinTimesPerTour, Integer fMaxTimesPerTour,
			String fUserFaints, Integer fRoundsToLoad, Integer fPp, String fTrapping, Integer fFlinchingProbability) {
		this.fId = fId;
		this.fName = fName;
		this.fCategory = fCategory;
		this.fPower = fPower;
		this.fAccuracy = fAccuracy;
		this.fMinTimesPerTour = fMinTimesPerTour;
		this.fMaxTimesPerTour = fMaxTimesPerTour;
		this.fUserFaints = fUserFaints;
		this.fRoundsToLoad = fRoundsToLoad;
		this.fPp = fPp;
		this.fTrapping = fTrapping;
		this.fFlinchingProbability = fFlinchingProbability;
	}

	public Long getfId() {
		return fId;
	}
	
	public void setfId(Long fId) {
		this.fId = fId;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getfCategory() {
		return fCategory;
	}
	
	public void setfCategory(String fCategory) {
		this.fCategory = fCategory;
	}
	
	public Long getfPower() {
		return fPower;
	}
	
	public void setfPower(Long fPower) {
		this.fPower = fPower;
	}
	
	public Integer getfAccuracy() {
		return fAccuracy;
	}
	
	public void setfAccuracy(Integer fAccuracy) {
		this.fAccuracy = fAccuracy;
	}
	
	public Integer getfMinTimesPerTour() {
		return fMinTimesPerTour;
	}

	public void setfMinTimesPerTour(Integer fMinTimesPerTour) {
		this.fMinTimesPerTour = fMinTimesPerTour;
	}

	public Integer getfMaxTimesPerTour() {
		return fMaxTimesPerTour;
	}

	public void setfMaxTimesPerTour(Integer fMaxTimesPerTour) {
		this.fMaxTimesPerTour = fMaxTimesPerTour;
	}

	public String getfUserFaints() {
		return fUserFaints;
	}

	public void setfUserFaints(String fUserFaints) {
		this.fUserFaints = fUserFaints;
	}

	public Integer getfRoundsToLoad() {
		return fRoundsToLoad;
	}

	public void setfRoundsToLoad(Integer fRoundsToLoad) {
		this.fRoundsToLoad = fRoundsToLoad;
	}

	public Integer getfPp() {
		return fPp;
	}

	public void setfPp(Integer fPp) {
		this.fPp = fPp;
	}

	public String getfTrapping() {
		return fTrapping;
	}

	public void setfTrapping(String fTrapping) {
		this.fTrapping = fTrapping;
	}

	public Integer getfFlinchingProbability() {
		return fFlinchingProbability;
	}

	public void setfFlinchingProbability(Integer fFlinchingProbability) {
		this.fFlinchingProbability = fFlinchingProbability;
	}

	private CategoryMove toCategoryMove(String categoryMoveString) {
		if (categoryMoveString.equals(CategoryMove.PHYSICAL.getValue())) {
			return CategoryMove.PHYSICAL;
		}else if (categoryMoveString.equals(CategoryMove.SPECIAL.getValue())) {
			return CategoryMove.SPECIAL;
		}else if (categoryMoveString.equals(CategoryMove.STATUS.getValue())) {
			return CategoryMove.STATUS;
		}else {
			return null;
		}
	}

	@Override
	public Object toEntity(JpaRepository repository) {
		if (fId == null) {
			return new Move(fName,toCategoryMove(fCategory),fPower,fAccuracy,fMinTimesPerTour,
					fMaxTimesPerTour,fUserFaints.equals("True"),fRoundsToLoad,fPp,fTrapping.equals("True"),fFlinchingProbability);
		}
		MoveRepository moveRepository = (MoveRepository) repository;
		Move move = moveRepository.getById(fId);
		return new Move(fId,fName,move.getType(),toCategoryMove(fCategory),fPower,fAccuracy,fMinTimesPerTour,
				fMaxTimesPerTour,fUserFaints.equals("True"),fRoundsToLoad,fPp,fTrapping.equals("True"),fFlinchingProbability);
	}

	@Override
	public void fromEntity(Object entity) {
		Move move = (Move) entity;
		this.fId = move.getId();
		this.fName = move.getName();
		this.fCategory = move.getCategory().toString();
		this.fPower = move.getPower();
		this.fAccuracy = move.getAccuracy();
		this.fMinTimesPerTour = move.getMinTimesPerTour();
		this.fMaxTimesPerTour = move.getMaxTimesPerTour();
		if (move.getUserFaints() != null) {
			this.fUserFaints = move.getUserFaints().toString();
		}
		this.fRoundsToLoad = move.getRoundsToLoad();
		this.fPp = move.getPp();
		if (move.getTrapping() != null) {
			this.fTrapping = move.getTrapping().toString();
		}
		this.fFlinchingProbability = move.getFlinchingProbability();
	}
	
}
