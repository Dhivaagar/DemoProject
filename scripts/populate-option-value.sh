#!/usr/bin/bash

OPTIONS=(major minor patch prerelease)

current_options=$(yq eval '.on.workflow_dispatch.inputs.version.options' "./.github/workflows/target-action.yml")

current_options_array=()
while read -r word; do
    current_options_array+=("$word")
done <<< "$current_options"

declare -a output_array=()

# shellcheck disable=SC2128
for i in $OPTIONS; do
    output_array+=("$i")
done

# Check if the values in the arrays are equal
if [[ "${current_options_array[*]}" == "${output_array[*]}" ]]; then
    echo "Values in YAML file are equal to values in array. No update needed."
else
    echo "Values in YAML file are not equal to values in array. Updating YAML file."
    # Construct YAML-compatible string
    options_string="["

    for option in "${output_array[@]}"; do
        options_string+="\\"$option\\", "
    done

    options_string="${options_string%, }]"

    yq eval ".on.workflow_dispatch.inputs.version.options = $options_string" "./.github/workflows/target-action.yml" > temp.yml && mv temp.yml "./.github/workflows/target-action.yml"
fi