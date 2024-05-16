#!/bin/bash

SCRIPT_DIR=$(dirname "$0")
SOURCE_YAML_FILE="$SCRIPT_DIR/../.github/workflows/target-action.yml"

# Define options
OPTIONS=(major minor patch prerelease)

# Read current options from YAML file
current_options=$(yq eval '.on.workflow_dispatch.inputs.version.options' "$SOURCE_YAML_FILE")

# Convert current options string to array
IFS=', ' read -r -a current_options_array <<< "$current_options"

# Check if the values in the arrays are equal
if [[ "${current_options_array[*]}" == "${OPTIONS[*]}" ]]; then
    echo "Values in YAML file are equal to values in array. No update needed."
else
    echo "Values in YAML file are not equal to values in array. Updating YAML file."
    # Construct YAML-compatible string
    options_string=$(printf '"%s", ' "${OPTIONS[@]}")
    options_string="[${options_string%, }]"

    # Update YAML file using yq
    yq eval ".on.workflow_dispatch.inputs.version.options = $options_string" "$SOURCE_YAML_FILE" -i
fi
